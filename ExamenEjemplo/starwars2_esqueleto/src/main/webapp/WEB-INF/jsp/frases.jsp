<%@ page import="es.taw.starwars.entity.FraseCelebre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 12/04/2023
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<FraseCelebre> frases = (List<FraseCelebre>) request.getAttribute("ListaFrases"); %>
<html>
<head>
    <title>Frases célebres</title>
</head>
<body>
<table border = 1>
    <tr>
        <th>PERSONAJE</th>
        <th>FRASE</th>
        <th>PELÍCULA</th>
    </tr>
    <% for (FraseCelebre f : frases) {
    %>
    <tr>
        <td><%= f.getPersonaje().getNombre() %></td>
        <td><%= f.getFrase() %></td>
        <td><a href="/pelicula?id=<%=f.getPelicula().getPeliculaId()%>"><%= f.getPelicula().getTitulo() %></a></td>
    </tr>
    <% } %>
</table>

</body>
</html>
