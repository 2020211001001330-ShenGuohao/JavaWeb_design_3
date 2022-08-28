<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/8/9
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医药销售管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<h2 style="text-align: center">
    注册超管
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="new_user">
                <div class="form-group">
                    <label for="user_username_add" class="col-md-2 control-label">username</label>
                    <div class="col-md-4">
                        <input type="text" name="user_username_add"  class="form-control" id="user_username_add" placeholder="请输入添加的用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_password_add" class="col-md-2 control-label">password</label>
                    <div class="col-md-4">
                        <input type="text" name="user_password_add"  class="form-control" id="user_password_add" placeholder="请输入添加的用户名密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="login">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="add" value="注册" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>
