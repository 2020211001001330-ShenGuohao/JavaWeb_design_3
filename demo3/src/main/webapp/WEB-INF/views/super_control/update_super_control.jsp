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
    更新超管
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="update_user">
                <div class="form-group">
                    <label for="user_username_update" class="col-md-2 control-label">username</label>
                    <div class="col-md-4">
                        <input type="text" value="${requestScope.user.username}" name="user_username_update"  class="form-control" id="user_username_update" placeholder="请输入更新之后的用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_password_update" class="col-md-2 control-label">password</label>
                    <div class="col-md-4">
                        <input type="text" value="${requestScope.user.password}" name="user_password_update"  class="form-control" id="user_password_update" placeholder="请输入更新之后的密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_user">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="update" value="更新" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>
