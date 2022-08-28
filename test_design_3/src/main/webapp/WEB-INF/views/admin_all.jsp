<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/6/7
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//
//    System.out.println("---------->"+path);
//    System.out.println(basePath);
%>
<html>
<head>
    <title>某某系统管理</title>
    <link  href="<%=basePath%>css/User.css" rel="stylesheet"/>
</head>
<body>

<center><h2>WELCOME,${requestScope.user_1.username}</h2></center>
<hr/> <br/><br/>

<div>
    <a href="test">用户</a>
</div>

</body>
</html>
