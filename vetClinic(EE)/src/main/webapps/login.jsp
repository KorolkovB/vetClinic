<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 17.03.2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please, log in!</title>
</head>
<body>

<form method="post" action="controller?action=login">
    <p><input type="text" name="login" size="10"/></p>
    <p><input type="password" name="password" size="10"/></p>
    <p><input type="submit" name="Log in"/></p>
</form>
</body>
</html>
