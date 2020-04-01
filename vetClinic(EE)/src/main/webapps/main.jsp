<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<c:set var="user" value="${sessionScope.user}"/>
<c:set var="client" value="${user.client}"/>
<c:set var="vet" value="${user.veterinarian}"/>
<c:set var="isAdmin" value="${user.admin}"/>
<c:set var="updated" value="${requestScope.updated}"/>
<c:set var="added" value="${requestScope.added}"/>

<c:choose>
    <c:when test="${user!=null}">
        <p>Welcome, user <c:out value="${user.login}"/>!</p>
        <c:choose>
            <c:when test="${vet!=null}">
                <p>You are registered in the vetclinic as a veterinarian
                    <c:out value="${vet.firstName}"/>
                    <c:out value="${vet.lastName}"/>.</p>
                <p>You can assign or remove a visit of the client at the <a href="controller?action=openVetPanel">veterinarian
                    panel</a>!</p>
            </c:when>
            <c:when test="${client!=null}">
                <p>You are registered in the vetclinic as a client.</p>
                <c:choose>
                    <c:when test="${updated!=null}">
                        <p><strong> <c:out value="${updated}"/>
                        </strong></p>
                    </c:when>
                    <c:when test="${added!=null}">
                        <p><strong> <c:out value="${added}"/>
                        </strong></p>
                    </c:when>
                    <c:otherwise>
                        <p>Your passport data and contacts:</p>
                    </c:otherwise>
                </c:choose>
                <p>First name: <c:out value="${client.firstName}"/>
                </p>
                <p>Last name: <c:out value="${client.lastName}"/>
                </p>
                <p>Passport series: <c:out value="${client.passportSeries}"/>
                </p>
                <p>Passport number: <c:out value="${client.phoneNumber}"/>
                </p>
                <p>Phone Number: <c:out value="${client.phoneNumber}"/>
                </p>
                <p>Email: <c:out value="${client.email}"/>
                </p>
                <p>You can change them <a href="editClientData.jsp">here</a>.</p>
                <c:if test="${client.pets!=null}">
                    <p>Here is list of your pets that are registered at the clinic:</p>
                    <table border="1">
                        <tr>
                            <td>Nickname</td>
                            <td>Age</td>
                            <td>Kind</td>
                            <td>Active diseases</td>
                        </tr>
                        <c:forEach items="${client.pets}" var="pet">
                            <c:if test="${!pet.deleted}">
                                <tr>
                                    <td><c:out value="${pet.nickname}"/>
                                    </td>
                                    <td><c:out value="${pet.age}"/>
                                    </td>
                                    <td><c:out value="${pet.kind.name}"/>
                                    </td>
                                    <td>
                                        <c:forEach items="${pet.diseases}" var="disease">
                                        <c:if test="${disease.active}">
                                            <c:out value="${disease.name}"/><br>
                                        </c:if>
                                        </c:forEach>
                                    <td>
                                        <form method="post" action="controller?action=removePet">
                                            <input type="hidden" name="petId" value="${pet.id}">
                                            <input type="submit" value="remove"
                                                   onclick="return confirm('Remove this pet?')">
                                        </form>
                                    </td>
                                    <td>
                                        <form method="post" action="controller?action=viewPetVisits">
                                            <input type="hidden" name="petId" value="${pet.id}">
                                            <input type="submit" value="visit list">
                                        </form>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </c:if>
                <p><a href="addingPet.jsp">+add a new pet</a></p>
            </c:when>
            <c:when test="${user.clientt}">
                <p>You aren't registered as a client!</p>
                <p>You can enter information about yourself <a href="editClientData.jsp">here</a>.</p>
                <p>This will allow you to add your pets and book them on a visit to the vet.</p>
            </c:when>
            <c:when test="${isAdmin==true}">
                <p>You are administrator of this application!</p>
                <p>You can go to the <a href="controller?action=admin">admin panel</a>!</p>
            </c:when>
        </c:choose>
        <br>
        <p><a href="controller?action=logout">Logout</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="login.jsp">Login</a></p>
        <p><a href="register.jsp">Register</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>
