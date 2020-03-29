<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 29.03.2020
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Active visits</title>
</head>
<body>
<c:set var="visits" value="${requestScope.visits}"/>
<p>Upcoming visits of the pet:</p>
<table border="1">
    <tr>
        <td>Visit Date/Time</td>
        <td>Veterinarian</td>
    </tr>
    <c:forEach items="${visits}" var="visit">
        <tr>
            <td>${visit.visitDateTime}</td>
            <td>${visit.vet.firstName} ${visit.vet.lastName}</td>
            <td>
                <form method="post" action="controller?action=viewPetVisits">
                <input type="hidden" name="removedVisitId" value="${visit.id}">
                <input type="hidden" name="petId" value="${visit.pet.id}">
                <input type="submit" value="remove"
                       onclick="return confirm('Remove this visit?')">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="editClientData.jsp">+add a visit</a></p>
<p><a href="controller?action=main">back to main page</a></p>
</body>
</html>
