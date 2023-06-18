<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 31/05/2023
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<CuentaEntity> listacuentas = (List<CuentaEntity>) request.getAttribute("listacuentas");%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="filtro" action="/filtrar">
    <table border="1">
        <tr>
            <td>Comisión: <form:select path="comision" items="${listacomision}" itemLabel="comision" itemValue="valor"/></td>
            <td>Saldo > <form:input path="saldo"/></td>
            <td><button>Filtrar</button></td>
        </tr>
    </table>
</form:form>
<a href="/reset"><button>Sin filtro</button></a>
<table border="1">
  <tr>
    <td>IBAN</td>
    <td>SALDO ACTUAL</td>
    <td>MOVIMIENTOS</td>
    <td>COMISIÓN APLICADA</td>
  </tr>
  <%for (CuentaEntity cuenta:listacuentas){%>
    <tr>
        <td><a href="/info?id=<%=cuenta.getCuentaid()%>"><%=cuenta.getIban()%></a></td>
    <td><%=cuenta.getSaldoactual()%></td>
    <td><% if(!cuenta.getMovimientosByCuentaid().isEmpty()){
        for (MovimientoEntity movimiento:cuenta.getMovimientosByCuentaid()) {%>
        <%=movimiento.getFecha()+"-"+movimiento.getDescripcion()+"-("+movimiento.getCantidad()+")"%><br>
        <%}
          }else{%>
          Sin Movimientos
         <%}%></td>
    <td><%=cuenta.getTipocomisionByComision().getComision()%></td>
    </tr>
  <%}%>
</table>
</body>
</html>
