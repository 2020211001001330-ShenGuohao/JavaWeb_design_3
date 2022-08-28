<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/8/1
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>医药销售管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        th,td{ text-align: center;vertical-align: middle;}
    </style>
    <script type="text/javascript" src="js/needed.js"></script>
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 45px;height: 75%">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/main" class="btn list-group-item" >
                    系统菜单
                </a>
                <a href="${pageContext.request.contextPath}/query_staff" class=" btn list-group-item" style="background-color:red;color: white">仓库管理员信息</a>
                <a href="${pageContext.request.contextPath}/query_warehouse" class="btn list-group-item">仓库信息</a>
                <a href="${pageContext.request.contextPath}/query_drag" class="btn list-group-item">药品信息</a>
                <a href="${pageContext.request.contextPath}/query_orderd" class="btn list-group-item">订单信息</a>
                <a href="${pageContext.request.contextPath}/query_client" class="btn list-group-item">客户信息</a>
                <a href="${pageContext.request.contextPath}/query_user" class="btn list-group-item">超管信息</a>
                <a href="${pageContext.request.contextPath}/query_statistics" class="btn list-group-item">存销统计</a>
                <a onclick="exit()" class="btn btn-warning list-group-item">退出</a>
            </div>
        </div>
        <div class="col-md-9 col-md-offset-1">
            <%--            <div>--%>
            <%--                <ol class="breadcrumb">--%>
            <%--                    <li><span class="glyphicon glyphicon-home"></span>&nbsp;--%>
            <%--                        <a href="#">主页</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="active"></li>--%>
            <%--                </ol>--%>
            <%--            </div>--%>
            <div align="center" style="padding-top: 25px;">
                <h1>仓库管理员信息管理</h1>
                <div class="row">
                    <div class="col-md-12" style="background: red">

                        <form method="get" action="query_staff">
                            <a class="btn btn-primary" href="add_staff">添加</a>
                            <input name="query" type="submit" value="查询" class="btn btn-success">
                            Sno: <input name="query_sno" type="text" style="height: 20px;width: 100px">
                            Sname:<input name="query_sname" type="text" style="height: 20px;width: 100px">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            Ssex: <input name="query_ssex" type="radio" value="男" style="height: 20px;">男
                                  <input name="query_ssex" type="radio"value="女" style="height: 20px;"> 女  <br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                            Sage:<input name="query_sage" type="text" style="height: 20px;width: 100px">

                            Sedu:<select  name="query_sedu">
                         <option value="">----请选择学历层次----</option>
                            <option>高中</option>
                            <option>专科</option>
                            <option>本科</option>
                            <option>研究生</option>
                            <option>博士</option>
                        </select>
                            Wno: <input name="query_wno" type="text" style="height: 20px;width: 100px">

                        </form>

                    </div>
                </div>

                <table class="table table-bordered table-striped " >
                    <tr>
                        <th>Sno</th>
                        <th>Sname</th>
                        <th>Ssex</th>
                        <th>Sage</th>
                        <th>Sedu</th>
                        <th>Wno</th>
                    </tr>
                    <c:choose>

                        <c:when test="${empty res}">

                            <tr>
                                <td colspan="6"><h3>没有找到</h3></td>
                            </tr>
                        </c:when>

                        <c:otherwise>
                            <c:forEach var="u" items="${res}">
                                <tr>

                                    <td>${u.sno}</td>
                                    <td>${u.sname}</td>
                                    <td>${u.ssex}</td>
                                    <td>${u.sage}</td>
                                    <td>${u.sedu}</td>
                                    <td>${u.wno}</td>
                                    <td>
                                        <a class="btn btn-warning" href="update_staff?update_staff_sno=${u.sno}">更新</a>

                                    </td>
                                    <td>

                                        <a class="btn btn-danger" onclick="delete_staff('${u.sno}','${u.sname}','${u.ssex}','${u.sage}','${u.sedu}','${u.wno}')">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>


                </table>

            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <hr style="height:1px;border:none;border-top:1px solid #ccc;"/>
            <div align="center" style="padding-top: 20px">
                software-ShenGuohao-1330<br/>
                +8613027256772   <br/>
                1964208075@qq.com
            </div>
        </div>
    </div>
</div>

<script>

    <c:if test="${!empty message}">setTimeout('test()',500);</c:if>

    function test(){
        alert("${message}");
    }

</script>
</body>
</html>
