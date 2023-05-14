<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.PurchaseOrder" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 29/03/2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<PurchaseOrder> lista = (List<PurchaseOrder>) request.getAttribute("pedidos");
%>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista de pedidos</h1>
<table border="1">
    <tr>
        <th>
            Número de pedido
        </th>
        <th>
            Producto
        </th>
        <th>
            Añadir pedido
        </th>
    </tr>

<%
    for (PurchaseOrder p : lista) {
%>
<tr>
    <td><%= p.getOrderNum()%> </td>
    <td><%= p.getProductByProductId().getDescription()%> </td>
</tr>

<%
    }
%>
</table>
<a href="/customer/nuevo-pedido"> Añadir</a>
</body>
</html>
