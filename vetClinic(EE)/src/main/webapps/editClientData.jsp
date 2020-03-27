<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 24.03.2020
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit your data</title>
</head>
<body>
<c:set var="user" value="${sessionScope.user}"/>
<c:set var="client" value="${user.client}"/>

<form method="post" action="controller?action=changeClientData">
    <p><input type="text" name="firstName" value="${client.firstName}" maxlength="45" minlength="1" size="45"/></p>
    <p><input type="text" name="lastName" value="${client.lastName}" maxlength="45" minlength="1" size="45"/></p>
    <p><input type="number" name="passportSeries" value="${client.passportSeries}" maxlength="4" minlength="4"
              size="4"/></p>
    <p><input type="number" name="passportNumber" value="${client.passportNumber}" maxlength="6" minlength="6"
              size="6"/></p>
    <p><input type="text" name="phoneNumber" value="${client.phoneNumber}" maxlength="9" minlength="9" size="9"/></p>
    <p><input type="text" name="email" value="${client.email}" maxlength="45" minlength="0" size="45"/></p>
    <p><input type="submit" name="Change"/></p>
</form>
</body>
</html>
