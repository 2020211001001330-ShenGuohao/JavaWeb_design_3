
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>医药销售管理系统</title>
    <style type="text/css">

        img:hover{
            transform:scale(1.1,1.1);
            transition: all 0.6s
        }
    </style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/needed.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/echarts/5.3.3/echarts.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 45px;height: 75%">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/main" class="btn list-group-item" >
                    系统菜单
                </a>
                <a href="${pageContext.request.contextPath}/query_staff" class=" btn list-group-item">仓库管理员信息</a>
                <a href="${pageContext.request.contextPath}/query_warehouse" class="btn list-group-item">仓库信息</a>
                <a href="${pageContext.request.contextPath}/query_drag" class="btn list-group-item">药品信息</a>
                <a href="${pageContext.request.contextPath}/query_orderd" class="btn list-group-item">订单信息</a>
                <a href="${pageContext.request.contextPath}/query_client" class="btn list-group-item">客户信息</a>
                <a href="${pageContext.request.contextPath}/query_user" class="btn list-group-item">超管信息</a>
                <a href="${pageContext.request.contextPath}/query_statistics" class="btn list-group-item"style="background-color:red;color: white; ">存销统计</a>

                <a onclick="exit()" class="btn btn-warning list-group-item">退出</a>
            </div>
        </div>
        <div class="col-md-10">



                <div class="row">
                    <div id="s1"class="col-md-4" style="height: 292.5px;"></div>
                    <div id="s2"class="col-md-4" style="height: 292.5px;background-color: white"></div>
                    <div id="s3"class="col-md-4" style="height:292.5px;"></div>

                </div>
                <div class="row">
                    <div id="s4" class="col-md-4" style="height:292px;"></div>
                    <div id="s5" class="col-md-4"style="height: 292px"></div>
                    <div id="s6" class="col-md-4" style="height:292px;"></div>
                </div>
        </div>
    </div>
    <script>
        var main=echarts.init(document.getElementById("s1"));
        var option = {
            legend: {},
            tooltip: {},
            dataset: {
                source: [
                    ['仓库','销售额','销售量','剩余量'],
                    <c:forEach var="o" items="${requestScope.stastics}">
                        ['${o.wno.trim()}号仓库',${o.saleprice},${o.salesum},${o.serplus}],
                    </c:forEach>
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }, { type: 'bar' },{ type: 'bar' }]
        };

        option && main.setOption(option);

    </script>
    <script >
        var main=echarts.init(document.getElementById("s2"));
        var option = {
            backgroundColor: '#f7f9fa',
            title: {
                text: '销售额各仓库占比',
                left: 'center',
                top: 20,
                textStyle: {
                    color: 'red'
                }
            },
            tooltip: {
                trigger: 'item'
            },
            visualMap: {
                show: false,
                min: 100,
                max: 1200,
                inRange: {
                    colorLightness: [0, 1]
                }
            },
            series: [
                {
                    name: 'Access From',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '50%'],
                    data: [
                        <c:forEach var="o" items="${requestScope.stastics}">

                        {value: ${o.saleprice},name:'${o.wno.trim()}号仓库' },

                        </c:forEach>
                    ].sort(function (a, b) {
                        return a.value - b.value;
                    }),
                    roseType: 'radius',
                    label: {
                        color: 'red'
                    },
                    labelLine: {
                        lineStyle: {
                            color: 'red'
                        },
                        smooth: 0.2,
                        length: 5,
                        length2: 10
                    },
                    itemStyle: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    },
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };


        option&&main.setOption(option);
    </script>
    <script>
        var main=echarts.init(document.getElementById("s3"));

        var option = {
            legend: {},
            tooltip: {},
            title: {
                text: '客户消费总额',
                left: 'center',
                top: 20,
                textStyle: {
                    color: 'red'
                }
            },
            dataset: {
                source: [

                    <c:forEach var="o" items="${requestScope.client_buy}">
                     ['${o.cname.trim()}',${o.buy_sum}],
                    </c:forEach>
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }]
        };
        option&&main.setOption(option);
    </script>


    <script>
        var main=echarts.init(document.getElementById("s4"));
        var option = {
            legend: {},
            tooltip: {},
            title: {
                text: '1号仓库药品剩余量',
                left: 'center',
                top: 20,
                textStyle: {
                    color: 'red'
                }
            },
            dataset: {
                source: [

                    <c:forEach var="o" items="${requestScope.serpluses_1}">
                    ['${o.dname.trim()}',${o.serplus}],
                    </c:forEach>
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }]
        };
        option&&main.setOption(option);
    </script>

    <script>
        var main=echarts.init(document.getElementById("s5"));
        var option = {
            legend: {},
            tooltip: {},
            title: {
                text: '2号仓库药品剩余量',
                left: 'center',
                top: 20,
                textStyle: {
                    color: 'red'
                }
            },
            dataset: {
                source: [

                    <c:forEach var="o" items="${requestScope.serpluses_2}">
                    ['${o.dname.trim()}',${o.serplus}],
                    </c:forEach>
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }]
        };
        option&&main.setOption(option);
    </script>
    <script>
        var main=echarts.init(document.getElementById("s6"));
        var option = {
            legend: {},
            tooltip: {},
            title: {
                text: '3号仓库药品剩余量',
                left: 'center',
                top: 20,
                textStyle: {
                    color: 'red'
                }
            },
            dataset: {
                source: [

                    <c:forEach var="o" items="${requestScope.serpluses_3}">
                    ['${o.dname.trim()}',${o.serplus}],
                    </c:forEach>
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }]
        };
        option&&main.setOption(option);
    </script>


    <div class="row">
        <div class="col-md-12">
            <hr style="height:1px;border:none;border-top:1px solid #ccc;"/>
            <div align="center">
                software-ShenGuohao-1330<br/>
                +8613027256772   <br/>
                1964208075@qq.com
            </div>
        </div>
    </div>
</div>

</body>
</html>