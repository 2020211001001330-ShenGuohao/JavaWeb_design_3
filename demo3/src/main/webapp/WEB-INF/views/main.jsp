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
    <style type="text/css">

        img:hover{
            transform:scale(1.1,1.1);
            transition: all 0.6s
        }
    </style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/needed.js"></script>
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 45px;height: 75%">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/main" class="btn list-group-item" style="background-color:red;color: white">
                    系统菜单
                </a>
                <a href="${pageContext.request.contextPath}/query_staff" class=" btn list-group-item">仓库管理员信息</a>
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
<%--            <div>
                <ol class="breadcrumb">
                    <li><span class="glyphicon glyphicon-home"></span>&nbsp;
                        <a href="#">主页</a>
                    </li>
                    <li class="active"></li>
                </ol>
            </div>--%>
            <div align="center" style="padding-top: 25px;">
                <h1>医药销售管理系统,Welcome Back !!!</h1>
                <br/><br/><br/>
                <img src="img/m1.jpg" style="height: 150px;
                                              width: 150px;
                                              border-radius: 80px;">
                <h1>${sessionScope.username}</h1>
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

</body>
</html>