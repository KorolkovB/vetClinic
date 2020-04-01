<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit your data</title>
</head>
<body>
<c:set var="user" value="${sessionScope.user}"/>
<c:set var="client" value="${user.client}"/>

<c:choose>
    <c:when test="${client!=null}">
        <form method="post" action="controller?action=changeClientData">
            <p>FirstName: <input required type="text" name="firstName" value="${client.firstName}" maxlength="45"
                                 minlength="1" size="45"/></p>
            <p>LastName: <input required type="text" name="lastName" value="${client.lastName}" maxlength="45"
                                minlength="1" size="45"/></p>
            <p>Passport Series: <input required type="number" name="passportSeries" value="${client.passportSeries}"
                                      maxlength="4" minlength="4" size="4"/></p>
            <p>Passport Number: <input required type="number" name="passportNumber" value="${client.passportNumber}"
                                      maxlength="6" minlength="6" size="6"/></p>
            <p>Phone Number: <input type="text" name="phoneNumber" value="${client.phoneNumber}" maxlength="9"
                                   minlength="9" size="9"/></p>
            <p>Email: <input type="text" name="email" value="${client.email}" maxlength="45" minlength="0" size="45"/>
            </p>
            <p><input type="submit" name="Change" onclick="return confirm('Commit this changes?')"/></p>
            <p><a href="controller?action=main">back to main page</a></p>
        </form>
    </c:when>
    <c:otherwise>
        <form method="post" action="controller?action=changeClientData">
            <p>FirstName: <input required type="text" name="firstName" value="" maxlength="45" minlength="1" size="45"/>
            </p>
            <p>LastName: <input required type="text" name="lastName" value="" maxlength="45" minlength="1" size="45"/>
            </p>
            <p>Passport Series: <input required type="number" name="passportSeries" value="" maxlength="4" minlength="4"
                                      size="4"/></p>
            <p>Passport Number: <input required type="number" name="passportNumber" value="$" maxlength="6" minlength="6"
                                      size="6"/></p>
            <p>Phone Number: <input type="text" name="phoneNumber" value="" maxlength="9" minlength="9" size="9"/></p>
            <p>Email: <input type="text" name="email" value="" maxlength="45" minlength="0" size="45"/></p>
            <p><input type="submit" name="Change" onclick="return confirm('Commit this changes?')"/></p>
            <p><a href="controller?action=main">back to main page</a></p>
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
