<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaclienteEntity" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 01/06/2023
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%CuentaEntity cuenta= (CuentaEntity) request.getAttribute("cuenta");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Datos de la cuenta corriente:</h1>
<table border="1">
  <tr>
    <td>IBAN:</td>
    <td><%=cuenta.getIban()%></td>
  </tr>
  <tr>
    <td>FECHA DE CREACIÓN:</td>
    <td><%=cuenta.getFechacreacion()%></td>
  </tr>
  <tr>
    <td>SALDO:</td>
    <td><%=cuenta.getSaldoactual()%></td>
  </tr>
  <tr>
    <td>CLIENTES:</td>
    <td>
    <%for (CuentaclienteEntity cuentacliente:cuenta.getCuentaclientesByCuentaid()) {%>
    <a href="/cambiorol?id=<%=cuentacliente.getCuentaclienteid()%>"><%=cuentacliente.getClienteByClienteid().getNie()+" - "+ cuentacliente.getClienteByClienteid().getNombrecompleto()
            +" ("+cuentacliente.getRolclienteByRolid().getDescripcion() +") "%></a> <a href="/relacion?id=<%=cuentacliente.getCuentaclienteid()%>">x</a><br>
      <%}%>
    </td>
  </tr>
</table><br>
<a href="/">Volver al listado</a>
</body>
</html>
