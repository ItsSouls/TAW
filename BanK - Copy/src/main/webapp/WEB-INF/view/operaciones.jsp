<%@ page import="es.uma.taw.bank.entity.TransaccionEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw.bank.dao.PersonaRepository" %>
<%@ page import="es.uma.taw.bank.dto.TransaccionDTO" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: aleja
  Date: 22/04/2023
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<TransaccionDTO> operaciones = (List<TransaccionDTO>) request.getAttribute("operaciones");
%>
<head>
    <title>Operaciones de tu cuenta</title>
</head>
<body>
<h1>Lista de operaciones</h1>
<p>Ordenar por:</p>
<form:form method="post" modelAttribute="filtro" action="/cajero/operaciones/filtrar">
    <input hidden="true" value="<%= request.getAttribute("idCuenta") %>" name="cuenta">
    Fecha de Ejecución: <form:checkbox path="fechaEjecucion"></form:checkbox>
    Cantidad: <form:checkbox path="cantidad"></form:checkbox>
    Filtrar por cuenta: <form:select path="cuentaFiltro">
    <form:option value="" label="-------"></form:option>
    <form:options items="${cuentas}" itemLabel="ibanCuenta" itemValue="id"></form:options>
</form:select>
    <form:button>Filtrar</form:button>
</form:form>
<table border="1">
    <tr>
        <th>FECHA DE INSTRUCCIÓN</th>
        <th>FECHA DE EJECUCIÓN</th>
        <th>CANTIDAD</th>
        <th>CUENTA ORIGEN</th>
        <th>CUENTA DESTINO</th>
    </tr>
    <%
        for(TransaccionDTO t: operaciones){
    %>
    <tr>
        <td><%= t.getFechaInstruccion().toString() %></td>
        <td><%= t.getFechaEjecucion().toString() %></td>
        <td><%= t.getCantidad() %></td>
        <td><%= t.getIbanOrigen() %></td>
        <td><%= t.getIbanDestino() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
