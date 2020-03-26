<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 17.03.2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Please, log in!</title>
</head>
<body>
<c:if test="${requestScope.registrationOk !=null}">
    <c:out value="${requestScope.registrationOk}"/>
</c:if>
<form method="post" action="controller?action=login">
    <p><input type="text" name="login" size="10"/></p>
    <p><input type="password" name="password" size="10"/></p>
    <p><input type="submit" name="Log in"/></p>
</form>
<c:if test="${requestScope.notFound!=null}">
    <c:out value="${requestScope.notFound}"/>
    <p>You can try to enter your username and password again or <a href="register.jsp">register now</a>.</p>
</c:if>
</body>
</html>