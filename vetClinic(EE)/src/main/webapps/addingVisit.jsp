<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add visit</title>
</head>
<body>
<%DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");%>
<%String minDateTime = LocalDateTime.now().format(formatter);%>
<c:set var="vets" value="${sessionScope.vets}"/>
<c:set var="petId" value="${requestScope.petId}"/>
<form method="post" action="controller?action=viewPetVisits">
    <p>Vet:
        <select required name="vet" size="1">
            <c:forEach items="${vets}" var="vet">
                <option>(
                    <c:forEach items="${vet.specializations}" var="spec">
                        ${spec.name}
                    </c:forEach>
                    ) ${vet.firstName} ${vet.lastName} (${vet.id})
                </option>
            </c:forEach>
        </select>
    </p>
    <p>Visit Date/Time: <input required type="datetime-local" name="visitDateTime" min="<%=minDateTime%>"/></p>
    <p><input type="hidden" name="petId" value="${petId}"></p>
    <p><input type="hidden" name="addVisit" value="1"></p>
    <p><input type="submit" name="add visit" onclick="return confirm('Add visit?')"/></p>
    <p><a href="controller?action=main">back to main page</a></p>
</form>
</body>
</html>
