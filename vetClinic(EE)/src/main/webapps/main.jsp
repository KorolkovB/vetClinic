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

<%if (user!= null) {%>
    <%user = (User) session.getAttribute("user");%>
    <p>Welcome, user <%=user.getLogin()%>!</p>
    <%if (vet!= null) {%>
        <%vet = (Veterinarian) session.getAttribute("vet");%>
        <p>You are registered as a veterinarian <%=vet.getFirstName()%> <%=vet.getLastName()%>.</p>
        <p>You can assign or remove a visit of the client at the <a href="controller?action=vet">veterinarian panel</a>!</p>
    <%} else if (client!= null) {%>
        <%client = (Client) session.getAttribute("client");%>
        <p>You are registered as a client <%=client.getFirstName()%> <%=client.getLastName()%>.</p>
        <p>Your passport data and contacts:</p>
        <p>Passport series: <%=client.getPassportSeries()%></p>
        <p>Passport number: <%=client.getPassportNumber()%></p>
        <p>Phone Number: <%=client.getPhoneNumber()%></p>
        <p>Email: <%=client.getEmail()%></p>
        <p>You can change them <a href="controller?action=change">here</a>.</p>

    <%} else if (client== null) {%>
    <%client = (Client) session.getAttribute("client");%>
    <p>You are registered as a client <%=client.getFirstName()%> <%=client.getLastName()%>.</p>
    <p>Your passport data and contacts:</p>
    <p>Passport series: <%=client.getPassportSeries()%></p>
    <p>Passport number: <%=client.getPassportNumber()%></p>
    <p>Phone Number: <%=client.getPhoneNumber()%></p>
    <p>Email: <%=client.getEmail()%></p>
    <p>You can change them <a href="controller?action=change">here</a>.</p>

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
