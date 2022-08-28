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
    更新药品
</h2>
<hr/>

<br/><br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="update_drag">
                <div class="form-group">
                    <label for="drag_dno_update" class="col-md-2 control-label">Dno</label>
                    <div class="col-md-4">
                        <input type="text" value="${update_drag.dno}" name="drag_dno_update"  class="form-control" id="drag_dno_update" placeholder="请输入更新之后的药品号">
                    </div>
                </div>

                <div class="form-group">
                    <label for="drag_dname_update" class="col-md-2 control-label">Dname</label>
                    <div class="col-md-4">
                        <input type="text" value="${update_drag.dname}"name="drag_dname_update"  class="form-control" id="drag_dname_update" placeholder="请输入更新之后的药品名称">
                    </div>
                </div>

                <div class="form-group">
                    <label for="drag_dsum_update" class="col-md-2 control-label">Dsum</label>
                    <div class="col-md-4">
                        <input type="text" value="${update_drag.dsum}"name="drag_dsum_update"  class="form-control" id="drag_dsum_update" placeholder="请输入更新之后的药品数目">
                    </div>
                </div>

                <div class="form-group">
                    <label for="drag_dprice_update" class="col-md-2 control-label">Dprice</label>
                    <div class="col-md-4">
                        <input type="text" value="${update_drag.dprice}"name="drag_dprice_update"  class="form-control" id="drag_dprice_update" placeholder="请输入更新之后的药品单价">
                    </div>
                </div>

                <div class="form-group">
                    <label for="drag_wno_update" class="col-md-2 control-label">Wno</label>
                    <div class="col-md-4">
                        <input type="text" value="${update_drag.wno}" name="drag_wno_update"  class="form-control" id="drag_wno_update" placeholder="请输入更新之后的药品的入库号">
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_drag">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="update" value="更新" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>

