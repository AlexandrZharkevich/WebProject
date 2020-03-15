<%--
  Created by IntelliJ IDEA.
  User: MrBregovich
  Date: 15.03.2020
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h2>Введите данные для регистрации</h2>
<p style="color: red">${errorMessage}</p>
<form action="RegisterServlet" method="post">
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
    <p><a href="LoginServlet" class="badge badge-light">Вход</a></p>
</form>
</body>
</html>
