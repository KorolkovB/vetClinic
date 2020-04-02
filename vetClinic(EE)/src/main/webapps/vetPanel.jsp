<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vet panel</title>
</head>
<body>
<p>Your visits:</p>
<c:set var="visits" value="${sessionScope.user.veterinarian.visits}"/>
<table border="1">
    <tr>
        <td>Client name</td>
        <td>Pet kind</td>
        <td>Pet nickname</td>
        <td>Pet age</td>
        <td>Room</td>
        <td>Visit date</td>
        <td>Visited</td>
    </tr>
    <c:forEach items="${visits}" var="visit">
        <tr>
            <td>${visit.pet.client.firstName} ${visit.pet.client.lastName}</td>
            <td>${visit.pet.kind.name}</td>
            <td>${visit.pet.nickname}</td>
            <td>${visit.pet.age}</td>
            <td>${visit.room.name}</td>
            <td>${visit.visitDateTime}</td>
            <td>${visit.visited}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
