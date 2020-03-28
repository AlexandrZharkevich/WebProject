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
<form action="LoginServlet" method="post">
    <div class="form-group">
        <label for="name">Name</label><br>
        <input id="name" class="form-control form-control-lg" type="text" name="name" placeholder="Введите имя">
    </div>
    <div class="form-group">
        <label for="password">Password</label><br>
        <input id="password" class="form-control form-control-lg" type="password" name="password"
               placeholder="Введите пароль">
    </div>
    <button type="submit" class="btn btn-primary btn-lg">Отправить</button>
    <p><a href="RegisterServlet" class="badge badge-light">Регистрация</a></p>
</form>
</body>
</html>
