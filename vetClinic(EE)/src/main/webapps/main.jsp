<%@ page import="java.sql.Connection" %>
<%@ page import="entities.User" %>
<%@ page import="entities.Client" %>
<%@ page import="entities.Veterinarian" %><%--
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

<%if (user!= null) {%>
    <p>Welcome, user <%=user.getLogin()%>!</p>
    <%if (vet!= null) {%>
        <%vet = (Veterinarian) session.getAttribute("vet");%>
        <p>You are registered in the vetclinic as a veterinarian <%=vet.getFirstName()%> <%=vet.getLastName()%>.</p>
        <p>You can assign or remove a visit of the client at the <a href="controller?action=vet">veterinarian panel</a>!</p>
    <%} else if (client!= null) {%>
        <%client = (Client) session.getAttribute("client");%>
        <p>You are registered in the vetclinic as a client.</p>
        <%if (updated!= null) {%>
            <p><strong><%=updated%></strong></p>
        <%} else {%>
            <p>Your passport data and contacts:</p>
        <%}%>

        <p>First name: <%=client.getFirstName()%></p>
        <p>Last name: <%=client.getLastName()%> </p>
        <p>Passport series: <%=client.getPassportSeries()%></p>
        <p>Passport number: <%=client.getPassportNumber()%></p>
        <p>Phone Number: <%=client.getPhoneNumber()%></p>
        <p>Email: <%=client.getEmail()%></p>
        <p>You can change them <a href="editClientData.jsp">here</a>.</p>
        <p>You can also add or remove your pets. And book them on a visit to the vet
            <a href="controller?action=editPetList.">here</a>.</p>

    <%} else if (user.isClient()) {%>
        <p>You aren't registered as a client!</p>
        <p>You can enter information about yourself <a href="controller?action=becomeAClient">here</a>.</p>
        <p>This will allow you to add your pets and book them on a visit to the vet.</p>

    <%} else if ((Boolean) session.getAttribute("isAdmin")) {%>
        <p>You are administrator of this application!</p>
        <p>You can go to the <a href="controller?action=admin">admin panel</a>!</p>
    <%} %>
<%} else {%>
    <p><a href="login.jsp">Login</a></p>
    <p><a href="register.jsp">Register</a></p>
<%}%>
</body>
</html>
