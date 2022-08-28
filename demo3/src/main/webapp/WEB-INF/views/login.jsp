<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/8/6
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>用户登录</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script>

        <c:if test="${!empty message}">setTimeout('test()',500);</c:if>

        function test(){
            alert("${message}");
        }

    </script>
</head>


<body>
<h1 style="text-align: center;">医药销售管理系统</h1>
<hr/>


    <div   style="text-align: center;margin-top: 150px;">


   <%-- <form method="post" action="login">

        <input type="text" name="username" placeholder="请输入用户名" value="${cookie.cusername.value}"><br/><br/>
        <input type="password" name="password" placeholder="请输入密码" value="${cookie.cpassword.value}"><br/>
        <input type="checkbox" name="remember" value="1" ${cookie.cremember.value.equals("1")? "checked":""} />remember me<br/>
        <input class="bn btn-warning" type="reset" name="reset" value="重置"> &nbsp;&nbsp;&nbsp;
        <input class="bn btn-success" type="submit" name="submit" value="登录">
role="form"
        <div class="form-group">
    </form>--%>
    <form class="form-horizontal" role="form" action="login" method="post">
        <div class="form-group">
            <label for="username" class="col-md-2 control-label col-md-offset-3" >username</label>
            <div class="col-md-2 ">
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" value="${cookie.cusername.value}">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-md-2 control-label col-md-offset-3">password</label>
            <div class="col-md-2 ">
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" value="${cookie.cpassword.value}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-4 col-md-4">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember" value="1" ${cookie.cremember.value.equals("1")? "checked":""} />remember me<br/>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-5 col-md-2">
                <a class="btn btn-warning" href="new_user">注册</a>  &nbsp;&nbsp;
                <button type="submit" class="btn btn-success">登录</button>

            </div>

        </div>

        

    </form>


</div>


</body>

</html>
