<%@ page import="es.taw.starwars.entity.Personaje" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.starwars.entity.Pelicula" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 16/04/2023
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Personaje> lista = (List<Personaje>) request.getAttribute("listapersonaje");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Datos de la película</h1>
<table>
    <tr>
        <td>
            <form:form modelAttribute="pelicula" method="post" action="/guardar">
                <form:hidden path="peliculaId"/>
                Título: <form:input path="titulo" size="50" maxlength="50"/><br>
                Año: <form:input path="anyo" size="4" maxlength="4"/><br>
                Texto de apertura: <br><form:textarea path="textoApertura" size="5000" maxlength="5000" cols="100" rows="50"/><br>
                <form:button>Guardar</form:button>
        </td>
        <td>
            Personajes:<br>
            <form:select path="personajeList" items="${listapersonaje}" itemValue="personajeId" itemLabel="nombre" selectedItems="${pelicula.personajeList}" size="50"/>
        </td>
        </form:form>
    </tr>
</table>
</body>
</html>
