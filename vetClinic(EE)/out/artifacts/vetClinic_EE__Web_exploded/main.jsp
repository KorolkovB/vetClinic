<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 16.03.2020
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.user.client}">
        <jstl:forEach items="${requestScope.pets}" var="pet">
            <br/>
            <p>Age: ${pet.age}</p>
            <p>Name: ${pet.nickname}</p>
        </jstl:forEach>
    </c:when>
    <c:otherwise>
        <p><a href="login.jsp">Login</a></p>
        <p><a href="register.jsp">Registration</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
