<%--
Created by IntelliJ IDEA.
User: sghcmy
Date: 2022/8/9
Time: 9:27
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>医药销售管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h2 style="text-align: center">
    更新仓库管理员
</h2>
<hr/>

<br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" role="form" method="post" action="update_staff">
                <div class="form-group">
                    <label for="staff_sno_update" class="col-md-2 control-label">sno</label>
                    <div class="col-md-5">
                        <input type="text" value="${requestScope.staff.sno}" name="staff_sno_update"  class="form-control" id="staff_sno_update" placeholder="请输入更新之后的仓库管理员编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="staff_sname_update" class="col-md-2 control-label">sname</label>
                    <div class="col-md-5">
                        <input type="text" value="${requestScope.staff.sname}" name="staff_sname_update"  class="form-control" id="staff_sname_update" placeholder="请输入更新之后的仓库管理员名字">
                    </div>
                </div>

                <div class="form-group">
                    <%--@declare id="staff_ssex_update"--%><label for="staff_ssex_update" class="col-md-2 control-label">ssex</label>
                    <div class="col-md-5">
                        <label class="radio-inline">
                            <input type="radio" name="staff_ssex_update"  value="男" ${"男".equals(requestScope.staff.ssex.trim())?"checked":""}> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="staff_ssex_update"  value="女"  ${"女".equals(requestScope.staff.ssex.trim())?"checked":""}> 女
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="staff_sage_update" class="col-md-2 control-label">sage</label>
                    <div class="col-md-5">
                        <input type="text" value="${requestScope.staff.sage}" name="staff_sage_update"  class="form-control" id="staff_sage_update" placeholder="请输入更新之后的仓库管理员年龄">
                    </div>
                </div>
                <div class="form-group">
                    <%--@declare id="staff_sedu_update"--%><label for="staff_sedu_update" class="col-md-2 control-label">sedu</label>
                    <div class="col-md-5">
                        <select class="form-control" name="staff_sedu_update">
                            <option>----请选择学历层次----</option>
                            <option <c:if test="${requestScope.staff.sedu.trim().equals('高中')}">selected</c:if> >高中</option>
                            <option <c:if test="${requestScope.staff.sedu.trim().equals('专科')}">selected</c:if> >专科</option>
                            <option <c:if test="${requestScope.staff.sedu.trim().equals('本科')}">selected</c:if> >本科</option>
                            <option <c:if test="${requestScope.staff.sedu.trim().equals('研究生')}">selected</c:if> >研究生</option>
                            <option <c:if test="${requestScope.staff.sedu.trim().equals('博士')}">selected</c:if> >博士</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="staff_wno_add" class="col-md-2 control-label">wno</label>
                    <div class="col-md-5">
                        <input type="text" value="${requestScope.staff.wno}" name="staff_wno_update"  class="form-control" id="staff_wno_add" placeholder="请输入更新之后的仓库管理员所在仓库号">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-3 col-md-offset-2">
                        <a class="btn bg-primary" href="query_staff">取消</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="update" value="更新" class="btn btn-success">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>




</body>
</html>

