<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/8/1
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 45px;height: 75%">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/main" class="list-group-item" style="background-color:red;color: white">
                    系统菜单
                </a>
                <a href="${pageContext.request.contextPath}/staff" class="list-group-item">仓库管理员信息</a>
                <a href="${pageContext.request.contextPath}/caete/allCaete" class="list-group-item">仓库信息</a>
                <a href="${pageContext.request.contextPath}/customer/selectAll" class="list-group-item">药品信息</a>
                <a href="${pageContext.request.contextPath}/order/selectAll" class="list-group-item">订单信息</a>
                <a href="${pageContext.request.contextPath}/userMessage/selectAll" class="list-group-item">客户信息</a>
                <a href="${pageContext.request.contextPath}/admin/loginInfo" class="list-group-item">退出</a>
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
                <h1>后台管理系统</h1>
                <table class="table table-bordered table-striped">
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
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

</body>
</html>