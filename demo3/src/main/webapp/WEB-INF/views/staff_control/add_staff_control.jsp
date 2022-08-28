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
    添加仓库管理员
</h2>
<hr/>

<br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="add_staff">
                <div class="form-group">
                    <label for="staff_sno_add" class="col-md-2 control-label">sno</label>
                    <div class="col-md-5">
                        <input type="text" name="staff_sno_add"  class="form-control" id="staff_sno_add" placeholder="请输入添加的仓库管理员编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="staff_sname_add" class="col-md-2 control-label">sname</label>
                    <div class="col-md-5">
                        <input type="text" name="staff_sname_add"  class="form-control" id="staff_sname_add" placeholder="请输入添加的仓库管理员名字">
                    </div>
                </div>

                <div class="form-group">
                    <%--@declare id="staff_ssex_add"--%><label for="staff_ssex_add" class="col-md-2 control-label">ssex</label>
                    <div class="col-md-5">
                    <label class="radio-inline">
                        <input type="radio" name="staff_ssex_add" id="staff_ssex_add_1" value="男"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="staff_ssex_add" id="staff_ssex_add_2"  value="女"> 女
                    </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="staff_sage_add" class="col-md-2 control-label">sage</label>
                    <div class="col-md-5">
                        <input type="text" name="staff_sage_add"  class="form-control" id="staff_sage_add" placeholder="请输入添加的仓库管理员年龄">
                    </div>
                </div>
                <div class="form-group">
                    <%--@declare id="staff_sedu_add"--%><label for="staff_sedu_add" class="col-md-2 control-label">sedu</label>
                    <div class="col-md-5">
                        <select class="form-control" name="staff_sedu_add">
                            <option>----请选择学历层次----</option>
                            <option>高中</option>
                            <option>专科</option>
                            <option>本科</option>
                            <option>研究生</option>
                            <option>博士</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="staff_wno_add" class="col-md-2 control-label">wno</label>
                    <div class="col-md-5">
                        <input type="text" name="staff_wno_add"  class="form-control" id="staff_wno_add" placeholder="请输入添加的仓库管理员所在仓库号">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_staff">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="add" value="添加" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>

