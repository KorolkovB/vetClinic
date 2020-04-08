<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vet panel</title>
</head>
<body>
<c:set var="visits" value="${sessionScope.user.veterinarian.visits}"/>
<c:set var="diseases" value="${sessionScope.diseases}"/>
<p>Your new visits:</p>
<table border="1">
    <tr>
        <td>Client name</td>
        <td>Pet kind</td>
        <td>Pet nickname</td>
        <td>Pet age</td>
        <td>Pet diseases</td>
        <td>Room</td>
        <td>Visit date</td>
        <td>Visited</td>
        <td>Edit visit</td>
    </tr>
    <c:forEach items="${visits}" var="newVisit">
        <c:choose>
            <c:when test="${newVisit.visited==false}">
                <tr>
                    <td>${newVisit.pet.client.firstName} ${newVisit.pet.client.lastName}</td>
                    <td>${newVisit.pet.kind.name}</td>
                    <td>${newVisit.pet.nickname}</td>
                    <td>${newVisit.pet.age}</td>
                    <td>
                        <form method="post" action="controller?action=viewPetVisits">
                            <select required name="disease" size="1">
                                <c:forEach items="${diseases}" var="disease">
                                    <option>${disease.name} (${disease.id})</option>
                                </c:forEach>
                            </select>
                        </form>
                    </td>
                    <td>${newVisit.room.name}</td>
                    <td>${newVisit.visitDateTime}</td>
                    <td>${newVisit.visited}</td>
                    <td>
                        <form method="post" action="editVisit.jsp">
                            <input type="hidden" name="clientName" value="${pet.id}">
                            <input type="hidden" name="petKind" value="${pet.id}">
                            <input type="hidden" name="petNickname" value="${pet.id}">
                            <input type="hidden" name="petAge" value="${pet.id}">
                            <input type="hidden" name="petDiseases" value="${pet.id}">
                            <input type="hidden" name="Room" value="${pet.id}">
                            <input type="hidden" name="Visit date" value="${pet.id}">
                            <input type="hidden" name="editVisit" value="${pet.id}">
                            <input type="submit" value="remove"
                                   onclick="return confirm('Remove this pet?')">
                        </form>
                    </td>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>
</table>


<p>Your previous visits:</p>
<table border="1">
    <tr>
        <td>Client name</td>
        <td>Pet kind</td>
        <td>Pet nickname</td>
        <td>Pet age</td>
        <td>Pet diseases</td>
        <td>Room</td>
        <td>Visit date</td>
        <td>Visited</td>
    </tr>
    <c:forEach items="${visits}" var="previousVisit">
        <c:choose>
            <c:when test="${previousVisit.visited}">
                <tr>
                    <td>${previousVisit.pet.client.firstName} ${previousVisit.pet.client.lastName}</td>
                    <td>${previousVisit.pet.kind.name}</td>
                    <td>${previousVisit.pet.nickname}</td>
                    <td>${previousVisit.pet.age}</td>
                    <td>
                        <c:forEach items="${previousVisit.pet.diseases}" var="disease">
                            ${disease}
                        </c:forEach>
                    </td>
                    <td>${previousVisit.room.name}</td>
                    <td>${previousVisit.visitDateTime}</td>
                    <td>${previousVisit.visited}</td>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>
</table>
</body>
</html>