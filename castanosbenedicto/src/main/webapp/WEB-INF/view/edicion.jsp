<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.junio2023.entity.TitulacionEntity" %>
<%@ page import="es.taw.junio2023.entity.AsignaturaEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alumno
  Date: 02/06/2023
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Datos de la titulación</h1>
<form:form method="post" action="/guardar" modelAttribute="titulacion">
  <form:hidden path="idtitulacion"/>
  <table border="1">
    <tr>
      <td>NOMBRE: </td>
      <td><form:input path="nombre" size="50"></form:input></td>
    </tr>
    <tr>
      <td>CENTRO: </td>
      <td><form:label path="centroByCentro"/>${titulacion.centroByCentro.nombre}</td>
    </tr>
    <tr>
      <td>Nivel: </td>
      <td><form:label path="nivelEstudiosByNivel"/>${titulacion.nivelEstudiosByNivel.nombre}</td>
    </tr>
    <tr>
      <td>ASIGNATURAS</td>
      <td><form:checkboxes path="asignaturaByAsignatura" items="${asignaturalist}" itemLabel="nombre" delimiter="<br>"></form:checkboxes></td>
    </tr>
    <tr>
    <td><form:button>Guardar</form:button></td>
    </tr>
  </table>
</form:form>
</body>
</html>
