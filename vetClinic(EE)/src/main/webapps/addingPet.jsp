<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 28.03.2020
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new pet</title>
</head>
<body>
<c:set var="kinds" value="${sessionScope.kinds}"/>
<form method="post" action="controller?action=addNewPet">
    <p>Kind:
        <select name="petKind" size="1">
        <c:forEach items="${kinds}" var="kind">
            <option>${kind.name}</option>
        </c:forEach>
        </select>
    </p>
    <p>Nickname: <input type="text" name="nickName" value="" maxlength="45" minlength="1" size="45"/></p>
    <p>Age: <input type="number" name="age" value="" min="1" max="99" size="2"/></p>
    <p><input type="submit" name="add" onclick="return confirm('Add this pet?')"/></p>
    <p><a href="controller?action=main">back to main page</a></p>
</form>

</body>
</html>
