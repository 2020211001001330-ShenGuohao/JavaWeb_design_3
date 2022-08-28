<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>

    <title>Document</title>
    <style type="text/css">
        .t1{
            background-color: black;
            border: 20px solid green;
            margin: 10px 20px 30px 40px;
            padding: 50px;

            height: 400px;
            width:400px;
        }
    </style>

</head>
<body>
<form method="post" action="try">
    ${message} <br/>
    <input name="username" type="text" placeholder="亲输入姓名"><br/>
<%--    <select name="test">--%>
<%--        <option>-----请选择username-----</option>--%>
<%--        <c:forEach var="u" items="${requestScope.test_1}">--%>
<%--        <option <c:if test="${u.equals('admin')}">selected</c:if> >${u}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
        <%--<select name="test">
            <option>----请选择学历层次----</option>
              <option>高中</option>
              <option>本科</option>
              <option >研究生</option>
        </select>--%>
<%--    <br/>--%>
<%--    <input type="checkbox" class="checkbox" name="remember" value="1" ${cookie.cremember.value.equals("1")? "checked":""} /> Keep me signed in--%>
<%--    <br/>--%>
<%--    <input type="checkbox" class="checkbox" name="remember" value="1" <%="1".equals(rememberMe)? "checked":""%>/> Keep me signed in--%>
    <input type="submit" name="submit" value="提交">

</form>
</body>

</html>