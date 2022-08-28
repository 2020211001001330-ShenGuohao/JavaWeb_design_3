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
    更新仓库
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="update_warehouse">
                <div class="form-group">
                    <label for="warehouse_wno_update" class="col-md-2 control-label">wno</label>
                    <div class="col-md-4">
                        <input type="text" value="${warehouse_update.wno}" name="warehouse_wno_update"  class="form-control" id="warehouse_wno_update" placeholder="请输入更新之后的仓库号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="warehouse_wname_update" class="col-md-2 control-label">wname</label>
                    <div class="col-md-4">
                        <input type="text" value="${warehouse_update.wname}" name="warehouse_wname_update"  class="form-control" id="warehouse_wname_update" placeholder="请输入更新之后的的仓库名称">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_warehouse">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="update" value="更新" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>


