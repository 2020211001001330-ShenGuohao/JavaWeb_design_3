<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/6/3
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateUser</title>
    <link  href="css/User.css" rel="stylesheet"/>
</head>
<body>
<%
    String id = request.getParameter("id");
    System.out.println("jsp :"+id);
%>

<table id="cen">
    <form action="update" method="post">
        <tr>
            <td> id:</td>
            <td><input name="id" type="text" value="${requestScope.before.id}"></td>
        </tr>
        <tr>
            <td> username:</td>
            <td><input name="username" type="text" value="${requestScope.before.username}"/></td>
        </tr>
        <tr>
            <td> password:</td>
            <td><input name="password" type="text" value="${requestScope.before.password}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input name="email" type="text" value="${requestScope.before.email}"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><input name="gender" type="radio" value="M" ${"M".equals(requestScope.before.gender)?"checked":""}/>Man
                <input name="gender" type="radio" value="F" ${"F".equals(requestScope.before.gender)?"checked":""}/>Female </td>
        </tr>

        <tr>
            <td>birthday:</td>
            <td><input name="birthday" type="date" value="${requestScope.before.birthday}"/></td>
        </tr>
        <tr>
            <td><input name="reset" type="reset" value="重置"/></td>
            <td><input name="up" type="submit" value="更新"></td>
        </tr>

    </form>
</table>
</body>
</html>
