<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.FraseCelebre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 16/04/2023
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<FraseCelebre> lista = (List<FraseCelebre>) request.getAttribute("frasescelebres");%>
<html>
<head>
    <title>Frases Celebres</title>
</head>
<body>
<form:form action="/filtrar" method="post" modelAttribute="filtro">
    Personajes: <form:checkbox path="checkpersonaje"/>
    Película: <form:checkbox path="checkpelicula"/>
    <form:button>Filtrar</form:button>
</form:form>
<table border="1">
    <tr>
        <td>PERSONAJE</td>
        <td>FRASE CELEBRE</td>
        <td>PELÍCULA</td>
    </tr>

        <%for (FraseCelebre f:lista) {%>
        <tr>
        <td><%=f.getPersonaje().getNombre()%></td>
        <td><%=f.getFrase()%></td>
        <td><a href="/editar?id=<%=f.getPelicula().getPeliculaId()%>"/><%=f.getPelicula().getTitulo()%></td>
        </tr>
        <%}%>

</table>

</body>
</html>
