<%@ page import="com.mac.musicdb.Entity.DiscoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 16/06/2023
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<DiscoEntity> listadiscos = (List<DiscoEntity>) request.getAttribute("discos");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>DISCOS de MAC</h1>
<input type="search" name="busqueda" id="busqueda" placeholder="Buscar disco"/><br>
  <br><table border="1">
    <tr>
      <td>ID</td>
      <td>TITULO</td>
      <td>ARTISTA/COMPOSITOR</td>
      <td>DISCOGRAFIA</td>
      <td>ESTILO</td>
      <td>AÑO</td>
      <td>FORMATO</td>
      <td>NUMERO DE DISCOS</td>
    </tr>
<%for (DiscoEntity disco:listadiscos) {%>
      <tr>
        <td><%=disco.getId()%></td>
        <td><%=disco.getTitulo()%></td>
        <td><%=disco.getArtistaCompositor()%></td>
        <td><%=disco.getDiscografia()%></td>
        <td><%=disco.getEstilo()%></td>
        <td><%=disco.getAno()%></td>
        <td><%=disco.getFormato()%></td>
        <td><%=disco.getNumerodediscos()%></td>
        <td><a href="/canciones?id=<%=disco.getId()%>">Canciones</a></td>
      </tr>
<%}%>
  </table>

</body>
</html>
