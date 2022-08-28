<%@ page import="java.sql.ResultSet" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  control.User: sghcmy
  Date: 2022/6/2
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//
//    System.out.println("---------->"+path);
//    System.out.println(basePath);
%>
<html>
<head>
    <title>userList</title>
    <link  href="<%=basePath%>css/User.css" rel="stylesheet"/>
</head>
<body>

<center id="test">用户管理</center>

<hr/>
<br/><br/><br/>
<%--<%--%>
<%--       List<control.User> users= (List<control.User>) request.getAttribute("res");--%>
<%--       for(control.User u:users){--%>
<%--           System.out.println(u);--%>
<%--       }--%>
<%--%>--%>





<table border="1" id="cen">


    <center>

        <form method="get" action="test">
            <input name="query" type="submit" value="查询">
    Id: <input name="l_id" type="text" style="height: 20px ;width: 50px">
    Username: <input name="l_username" type="text" style="height: 20px;width: 100px">
    Password:<input name="l_password" type="text" style="height: 20px;width: 100px">
    Email:<input name="l_email" type="text" style="height: 20px;width: 100px"/>
    birthday:<input name="l_birthday" type="text" style="height: 20px;width: 100px"/>
    Gender: <input name="l_gender" type="radio" value="M"/>Man
        <input name="l_gender" type="radio" value="F"/>Female
        </form>

    </center>


      <tr>
          <th>id</th>
          <th>username</th>
          <th>password</th>
          <th>email</th>
          <th>gender</th>
          <th>birthday</th>
      </tr>

      <c:forEach var="u" items="${res}">
      <tr>
          <td>${u.id}</td>
          <td>${u.username}</td>
          <td>${u.password}</td>
          <td>${u.email}</td>
          <td>${u.gender}</td>
          <td>${u.birthday}</td>
          <td>
              <div class="update">
               <button><a href="update?id=${u.id}">更新</a></button>
              </div>
          </td>
          <td>
              <div class="delete">
              <button><a href="delete?id=${u.id}">删除</a></button>
              </div>
          </td>

      </tr>
      </c:forEach>



</table>

<br/>
<%
    for(int i=1;i<=125;i++){
        out.println("&nbsp;");
    }
%>
<button style="width: 40px ; height: 40px" ><a href="add">添加</a></button>


</body>
</html>
