<%--
  Created by IntelliJ IDEA.
  User: MrBregovich
  Date: 07.03.2020
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: red">${errorMessage}</p>
<form action="login" method="post">
    <p>Name: <input type="text" name="name"></p>
    <p>Password: <input type="password" name="password"></p>
    <input type="submit">
</form>
</body>
</html>
