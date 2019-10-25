<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/25
  Time: 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>main</h3>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit">
</form>
<a href="/admin">admin</a>
<a href="/svip">svip</a>
<a href="/vip">vip</a>
</body>
</html>
