<%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/6/3
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>

</head>
<body>
<p id="test">
<center>添加用户</center>
</p>
<hr/>
<br/><br/><br/>


    <table id="cen">
        <form action="add" method="post">
        <tr>
            <td> id:</td>
            <td><input name="id" type="text"></td>
        </tr>
        <tr>
            <td> username:</td>
            <td><input name="username" type="text"/></td>
        </tr>
        <tr>
            <td> password:</td>
            <td><input name="password" type="text"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input name="email" type="text"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><input name="gender" type="radio" value="M"/>Man
                <input name="gender" type="radio" value="F"/>Female </td>
        </tr>

        <tr>
            <td>birthday:</td>
            <td><input name="birthday" type="date"/></td>
        </tr>
        <tr>
            <td><input name="reset" type="reset" value="重置"/></td>
            <td><input name="add" type="submit" value="添加"></td>
        </tr>

        </form>
    </table>





</body>
</html>
