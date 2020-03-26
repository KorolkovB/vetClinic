<%@ page import="entities.*" %><%--
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
<%User user = (User) session.getAttribute("user");%>
<%Client client = (Client) session.getAttribute("client");%>
<%Veterinarian vet = (Veterinarian) session.getAttribute("vet");%>
<%String updated = (String) request.getAttribute("updated");%>

<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <p>Welcome, user <%=user.getLogin()%>!</p>
        <c:choose>
            <c:when test="${sessionScope.vet!=null}">
                <%vet = (Veterinarian) session.getAttribute("vet");%>
                <p>You are registered in the vetclinic as a veterinarian <%=vet.getFirstName()%> <%=vet.getLastName()%>
                    .</p>
                <p>You can assign or remove a visit of the client at the <a href="controller?action=vet">veterinarian
                    panel</a>!</p>
            </c:when>
            <c:when test="${sessionScope.client!=null}">
                <%client = (Client) session.getAttribute("client");%>
                <p>You are registered in the vetclinic as a client.</p>
                <%if (updated != null) {%>
                <p><strong><%=updated%>
                </strong></p>
                <%} else {%>
                <p>Your passport data and contacts:</p>
                <%}%>

                <p>First name: <%=client.getFirstName()%>
                </p>
                <p>Last name: <%=client.getLastName()%>
                </p>
                <p>Passport series: <%=client.getPassportSeries()%>
                </p>
                <p>Passport number: <%=client.getPassportNumber()%>
                </p>
                <p>Phone Number: <%=client.getPhoneNumber()%>
                </p>
                <p>Email: <%=client.getEmail()%>
                </p>
                <p>You can change them <a href="editClientData.jsp">here</a>.</p>
                <%if (client.getPets() != null) {%>
                <p>Here is list of your pets that are registered at the clinic:</p>
                <table border="1">
                    <tr>
                        <td>Nickname</td>
                        <td>Age</td>
                        <td>Kind</td>
                        <td>Active diseases</td>
                    </tr>
                    <%for (Pet pet : client.getPets()) {%>
                    <tr>
                        <td><%=pet.getNickname()%>
                        </td>
                        <td><%=pet.getAge()%>
                        </td>
                        <td><%=pet.getKind().getName()%>
                        </td>
                        <td>
                                    <%for (Disease disease : pet.getDiseases()) {%>
                                    <%if (disease.isActive()) {%>
                                    <%=disease.getName()%><br>
                                    <%}%>
                                    <% }%>

                        <td>
                            <form method="post" action="controller?action=removePetFromClient">
                                <input type="hidden" name="petId" value="<%pet.getId();%>">
                                <input type="submit" value="remove">
                            </form>
                        </td>
                        <td>
                            <form method="post" action="controller?action=bookAVisit">
                                <input type="hidden" name="petId" value="<%pet.getId();%>">
                                <input type="submit" value="visit list">
                            </form>
                        </td>
                    </tr>
                    <% }%>
                </table>
                <%}%>
                <p><a href="controller?action=addPetToClient">+add a new pet</a></p>
            </c:when>
            <c:when test="${sessionScope.user.client}">
                <p>You aren't registered as a client!</p>
                <p>You can enter information about yourself <a href="controller?action=becomeAClient">here</a>.</p>
                <p>This will allow you to add your pets and book them on a visit to the vet.</p>
            </c:when>
            <c:when test="${sessionScope.isAdmin==true}">
                <p>You are administrator of this application!</p>
                <p>You can go to the <a href="controller?action=admin">admin panel</a>!</p>
            </c:when>
        </c:choose>
    </c:when>
    <c:otherwise>
        <p><a href="login.jsp">Login</a></p>
        <p><a href="register.jsp">Register</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>
