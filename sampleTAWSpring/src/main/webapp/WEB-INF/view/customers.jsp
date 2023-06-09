<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.sampletaw.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.MicroMarket" %><%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 15/2/23
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Customer> lista = (List<Customer>) request.getAttribute("clientes");
    List<MicroMarket> supermercados = (List<MicroMarket>) request.getAttribute("supermercados");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="cabecera.jsp"/>

<h1>Listado de clientes</h1>


<form:form action="/customer/filtrar" method="post" modelAttribute="filtro">
Buscar por: <br/>
 Contiene: <form:input path="texto" />
 Supermercado:
    <form:select multiple="true" path="zipSupermercados"  size="6" >
        <form:option value="" label="------" />
        <form:options items="${supermercados}" itemLabel="zipCode" itemValue="zipCode" />
    </form:select>
<button>Filtrar</button>
</form:form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>EMAIL</th>
        <th>NAME</th>
        <th>CREDIT LIMIT</th>
        <th>DISCOUNT CODE</th>
        <th>CITY</th>
        <th>MICROMARKET</th>
        <th></th>
        <th></th>
    </tr>
<%
    for (Customer cliente: lista) {
%>
    <tr>
        <td><%= cliente.getCustomerId() %></td>
        <td><%= cliente.getEmail() %></td>
        <td><%= cliente.getName() %></td>
        <td><%= cliente.getCreditLimit() %></td>
        <td><%= cliente.getDiscountCodeByDiscountCode().getRate() %></td>
        <td><%= cliente.getCity() %></td>
        <td><%= cliente.getMicroMarketByZip().getZipCode() %></td>
        <td><a href="/customer/editar?id=<%= cliente.getCustomerId() %>"> Editar</a></td>
        <td><a href="/customer/borrar?id=<%= cliente.getCustomerId() %>"> Borrar</a></td>
        <td><a href="/purchaseOrder/listar?idcliente=<%= cliente.getCustomerId() %>"> Pedidos</a></td>
    </tr>


<%
    }
%>
</table border="1">

<a href="/customer/nuevo" >Nuevo cliente ...</a>

</body>
</html>
