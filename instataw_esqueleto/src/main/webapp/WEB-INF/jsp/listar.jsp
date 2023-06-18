<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="es.taw.instataw.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.instataw.entity.Categoria" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 01/06/2023
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Post> listapost = (List<Post>) request.getAttribute("listapost");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%for (Post p:listapost) {%>
<table border="1">
    <tr>
        <td>
        <img src="<%=p.getUsuario().getImagen()%>" style="width: 30px"/>
        <%=p.getUsuario().getNickname()%>
        </td>
    </tr>
    <tr>
        <td><img src="<%=p.getImagen()%>" style="width: 300px"/></td>
    </tr>
    <tr>
        <td><textarea><%=p.getTexto()%></textarea></td>
    </tr>
    <tr><td>Fecha de publicación: <%=p.getFecha()%></td></tr>
    <tr><td>Categorías: <%
        for (Categoria c:p.getCategoriaList()) {%>
        #<%=c.getTexto()%>
        <%}%></td></tr>
</table><br>
<%}%>
</body>
</html>
