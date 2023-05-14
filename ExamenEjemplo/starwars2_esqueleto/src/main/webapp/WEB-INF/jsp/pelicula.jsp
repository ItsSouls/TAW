<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.Personaje" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 12/04/2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pelicula</title>
</head>
<body>
    <form:form action="/pelicula/guardar" modelAttribute="pelicula" method="post">
        <form:hidden path="peliculaId"/>
        Titulo: <form:input path="titulo" size="50" maxlength="50"/><br/>
        Año: <form:input path="anyo" size="4" maxlength="4"/><br/>
        Texto de apertura: <form:input path="textoApertura" size="5000" maxlength="5000"/><br/>
        Personajes: <form:select path="personajeList" items="${ListaPersonajes}" itemLabel="nombre"/>
        <form:button>Guardar</form:button>
    </form:form>

</body>
</html>
