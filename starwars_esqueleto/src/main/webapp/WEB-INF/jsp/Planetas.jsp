<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.Planeta" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.starwars.entity.Especie" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 16/04/2023
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Planeta> lista = (List<Planeta>) request.getAttribute("planetas");%>
<html>
<head>
    <title>Planetas</title>
    <h1>Listado de planetas</h1>
    <form:form action="/filtrar" method="post" modelAttribute="filtro">
        Caraterísticas del clima:   <form:select path="filtrar">
                                        <form:option value="" label="--------"/>
                                        <form:options items="${climas}"/>
                                    </form:select>
        <form:button>Filtrar</form:button>
    </form:form>
    <table border="1">
        <tr>
            <td>PLANETA</td>
            <td>CLIMA</td>
            <td>TERRENO</td>
            <td>ESPECIES(familia)</td>
        </tr>
        <%for (Planeta p:lista) {%>
        <tr>
            <td><%=p.getNombre()%></td>
            <td><%=p.getClima() != null ? p.getClima() : "" %></td>
            <td><%=p.getTerreno() != null ? p.getTerreno() : "" %></td>
            <td>
                <%for (Especie e:p.getEspecieList()) {%>
                    <a href="/editar?id=<%=e.getEspecieId()%>"><%=e.getEspecie() != null ? e.getEspecie() : "" %></a>(<%=e.getClasificacion().getFamilia()%>)
                <%}%>
            </td>
        </tr>
        <%}%>
    </table>
</head>
<body>


</body>
</html>
