<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/22
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/index" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="username">
    <input name="password">
    <input type="checkbox" name="remember-me">
    <input type="submit">
</form>
</body>
</html>
