<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/8/14
  Time: 9:32
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
    添加订单
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="add_orderd">
                <div class="form-group">
                    <label for="orderd_ono_add" class="col-md-2 control-label">ono</label>
                    <div class="col-md-4">
                        <input type="text" name="orderd_ono_add"  class="form-control" id="orderd_ono_add" placeholder="请输入添加的订单编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="orderd_dno_add" class="col-md-2 control-label">dno</label>
                    <div class="col-md-4">
                        <input type="text" name="orderd_dno_add"  class="form-control" id="orderd_dno_add" placeholder="请输入添加的订单的药品编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="orderd_cno_add" class="col-md-2 control-label">cno</label>
                    <div class="col-md-4">
                        <input type="text" name="orderd_cno_add"  class="form-control" id="orderd_cno_add" placeholder="请输入添加订单的客户编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="orderd_osum_add" class="col-md-2 control-label">osum</label>
                    <div class="col-md-4">
                        <input type="text" name="orderd_osum_add"  class="form-control" id="orderd_osum_add" placeholder="请输入添加订单的药品数目">
                    </div>
                </div>
                <div class="form-group">
                    <label for="orderd_bdate_add" class="col-md-2 control-label">bdate</label>
                    <div class="col-md-4">
                        <input type="text" name="orderd_bdate_add"  class="form-control" id="orderd_bdate_add" placeholder="请输入添加的订单日期">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_orderd">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="add" value="添加" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>

