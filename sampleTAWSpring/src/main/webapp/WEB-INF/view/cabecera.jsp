<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cabecera</title>
</head>
<body>

    <c:if test="${empty admin}">
        <jsp:forward page="/"/>
    </c:if>
    <table style="border:0px; width: 100%">
        <td>Bienvenido: ${admin.email}</td>
        <td><a href="/logout">Salir</a></td>
    </table>
</body>
</html>
