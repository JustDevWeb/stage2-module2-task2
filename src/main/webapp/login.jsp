<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE>
<html lang = "en">
<head>
<title> Registration page</title>
</head>
<h3>Init time: ${servletTimeInit}</h3>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="login">Login</label><br/>
    <input id="login" type="text" name="login" size="30"> <br/>
    <label for="password">Password</label><br/>
    <input id="password" type="password" name="password" size="30"><br/>
    <input type="submit" value="OK">
</form>
</body>
</html>
