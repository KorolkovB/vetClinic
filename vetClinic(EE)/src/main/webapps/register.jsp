<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="controller?action=register">
    <p><input type="text" name="login" size="10"/></p>
    <p><input type="password" name="password" size="10"/></p>
    <p><input type="submit" name="Register me."/></p>
</form>
<c:if test="${requestScope.userExist!=null}">
    <c:out value="${requestScope.userExist}"/>
</c:if>
</body>
</html>
