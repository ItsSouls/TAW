<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 31/05/2023
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="cabecera.jsp"></jsp:include>
<h1>Realizar transferencias entre cuentas:</h1>
<form:form action="/guardar" modelAttribute="movimiento" method="post">
    <form:hidden path="cuentaByCuentaorigen"/>
    Destinatario: <form:select path="cuentaByCuentadestinatario" items="${todasmenosyo}"  itemLabel="iban" /><br>
    Descripcion: <form:input path="descripcion"/><br>
    Cantidad: <form:input path="cantidad"/><br>
    <form:button>Realizar</form:button>
</form:form>
</body>
</html>
