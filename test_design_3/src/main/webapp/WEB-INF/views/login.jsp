<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/6/6
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link  href="css/User.css" rel="stylesheet"/>
</head>
<body>
<center><h2>登录</h2></center>
<hr/> <br/><br/>

<form method="post" action="login" style="margin: 0 auto;width:250px;">

    ${requestScope.message}<br/>
    <label>用户名:</label><input name="username" type="text"> <br/>
        <label>密码:</label>&nbsp;&nbsp;&nbsp;<input name="password" type="password"> <br/>
    <center><input name="reset" type="reset" value="重置"> <input name="submit" type="submit" value="登录"></center>

</form>



</body>
</html>
