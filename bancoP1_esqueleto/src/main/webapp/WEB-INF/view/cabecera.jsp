<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 31/05/2023
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%CuentaEntity cuenta = (CuentaEntity) request.getAttribute("cuenta");%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table border="1">
  <tr>
    <td>Nombre: <%= cuenta.getClienteByTitular().getNombre() %>, <%= cuenta.getClienteByTitular().getApellidos() %></td>
    <td>NIE: <%= cuenta.getClienteByTitular().getNie() %></td>
    <td>Teléfono: <%= cuenta.getClienteByTitular().getTelefono() %></td>
    <td>Cuenta: <%= cuenta.getIban()%></td>
  </tr>
</table>
</body>
</html>

