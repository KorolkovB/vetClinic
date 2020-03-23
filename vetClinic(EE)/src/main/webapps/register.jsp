<%--
  Created by IntelliJ IDEA.
  User: Viktor_Korolkov
  Date: 17.03.2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%String userExist = (String) request.getAttribute("userExist");%>
<form method="post" action="controller?action=register">
    <p><input type="text" name="login" size="10"/></p>
    <p><input type="password" name="password" size="10"/></p>
    <p><input type="submit" name="Register me."/></p>
</form>
<%if (userExist != null) {%>
<%=userExist%>
<%}%>

</body>
</html>
