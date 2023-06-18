<%@ page import="es.taw.junio2023.entity.TitulacionEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alumno
  Date: 02/06/2023
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<TitulacionEntity> listatitulaciones = (List<TitulacionEntity>) request.getAttribute("listatitulacionesporcentro");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Listado de Titulaciones</h1>
<table border="1">
    <tr>
        <td>NIVEL</td>
        <td>TITULACIÓN</td>
        <td></td>
    </tr>
    <%for (TitulacionEntity t:listatitulaciones) {%>
    <tr>
        <td><%=t.getNivelEstudiosByNivel().getNombre()%></td>
        <td><%=t.getNombre()%></td>
        <td><a href="/editar?id=<%=t.getIdtitulacion()%>">editar</a></td>
    </tr>
    <%}%>
</table>

</body>
</html>
