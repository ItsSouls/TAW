<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 31/05/2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<ClienteEntity> listaclientes = (List<ClienteEntity>) request.getAttribute("listaclientes");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table BORDER="1">
    <tr>
        <td>CLIENTE</td>
        <td>NIE</td>
        <td>IBAN</td>
        <td>SALDO ACTUAL</td>
        <td></td>
    </tr>
    <%for (ClienteEntity c:listaclientes) {%>
    <tr>
        <td><%=c.getNombre() +" "+ c.getApellidos()%></td>
        <td><%=c.getNie()%></td>
        <%for (CuentaEntity cuenta:c.getCuentasByClienteid()) {%>
            <td><%=cuenta.getIban()%></td>
            <td><%=cuenta.getSaldoactual()%></td>
            <td><a href="/activar?id=<%=cuenta.getCuentaid()%>"><%=cuenta.getActiva() == 0 ? "Activar" : "Desactivar"%></a></td>
            <td><a href="/transferencia?id=<%=cuenta.getCuentaid()%>">Realizar una transferencia</a></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
