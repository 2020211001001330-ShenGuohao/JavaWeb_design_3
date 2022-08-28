<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/8/1
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%--    <script type="text/javascript" src="bootstrap3/js/jquery-1.11.2.min.js"></script>--%>
<%--    <script type="text/javascript" src="bootstrap3/js/bootstrap.min.js"></script>--%>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 45px;height: 75%">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/main" class="list-group-item">
                    系统菜单
                </a>
                <a href="${pageContext.request.contextPath}/staff" class="list-group-item" style="background-color:red;color: white">仓库管理员信息</a>
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
                <h1>员工信息管理</h1>
                <div class="row">
                    <div class="col-md-12" style="background: red">

                        <form method="get" action="staff">
                            <a class="btn btn-primary" href="add">添加</a>
                            <input name="query" type="submit" value="查询" class="btn btn-success">
                            Id: <input name="l_id" type="text" style="height: 20px ;width: 50px">
                            Username: <input name="l_username" type="text" style="height: 20px;width: 100px">
                            Password:<input name="l_password" type="text" style="height: 20px;width: 100px">
                            Email:<input name="l_email" type="text" style="height: 20px;width: 100px"/> <br/>
                            birthday:<input name="l_birthday" type="text" style="height: 20px;width: 100px"/>
                            Gender: <input name="l_gender" type="radio" value="M"/>Man
                            <input name="l_gender" type="radio" value="F"/>Female
                        </form>
                    </div>
                </div>

                <table class="table table-bordered table-striped">
                    <tr>
                        <th>id</th>
                        <th>username</th>
                        <th>password</th>
                        <th>email</th>
                        <th>gender</th>
                        <th>birthday</th>
                    </tr>

                    <c:forEach var="u" items="${res}">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>${u.email}</td>
                            <td>${u.gender}</td>
                            <td>${u.birthday}</td>
                            <td>

                                    <a class="btn btn-warning" href="update?id=${u.id}">更新</a>

                            </td>
                            <td>

                                    <a class="btn btn-danger" href="delete?id=${u.id}">删除</a>
                            </td>

                        </tr>
                    </c:forEach>

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