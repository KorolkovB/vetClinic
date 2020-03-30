<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Active visits</title>
</head>
<body>
<c:set var="visits" value="${requestScope.visits}"/>
<c:set var="petId" value="${requestScope.petId}"/>
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
                    <input type="hidden" name="petId" value="${petId}">
                    <input type="submit" value="remove"
                           onclick="return confirm('Remove this visit?')">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<p>
<form method="post" action="controller?action=addVisitToPet">
    <input type="hidden" name="petId" value="${petId}">
    <input type="submit" value="+add a visit">
</form>
</p>
<p><a href="controller?action=main">back to main page</a></p>
</body>
</html>
