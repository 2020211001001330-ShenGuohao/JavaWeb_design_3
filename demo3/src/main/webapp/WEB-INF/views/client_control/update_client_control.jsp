<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/8/14
  Time: 8:11
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
    更新客户信息
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="update_client">
                <div class="form-group">
                    <label for="client_cno_update" class="col-md-2 control-label">cno</label>
                    <div class="col-md-4">
                        <input type="text" value="${requestScope.client.cno}" name="client_cno_update"  class="form-control" id="client_cno_update" placeholder="请输入更新之后的客户编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="client_cname_update" class="col-md-2 control-label">cname</label>
                    <div class="col-md-4">
                        <input type="text" value="${requestScope.client.cname}"name="client_cname_update"  class="form-control" id="client_cname_update" placeholder="请输入更新之后的客户名字">
                    </div>
                </div>
                <div class="form-group">
                    <label for="client_ctel_update" class="col-md-2 control-label">ctel</label>
                    <div class="col-md-4">
                        <input type="text" value="${requestScope.client.ctel}"name="client_ctel_update"  class="form-control" id="client_ctel_update" placeholder="请输入更新之后的客户电话">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_client">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="update" value="更新" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>

