<%@ page import="com.mac.musicdb.Entity.CancionEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mac.musicdb.Entity.DiscoEntity" %>
<%@ page import="com.mac.musicdb.Entity.InterpreteEntity" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 18/06/2023
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<CancionEntity> canciones = (List<CancionEntity>) request.getAttribute("canciones");%>
<%DiscoEntity disco = (DiscoEntity) request.getAttribute("disco");%>
<%List<InterpreteEntity> interpretes = (List<InterpreteEntity>) request.getAttribute("interpretes");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cancion del disco: <%=disco.getTitulo()%></h1>
<table border="1">
  <tr>
    <td>ID</td>
    <td>NOMBRE</td>
    <td>DURACION</td>
    <td>PISTA</td>
    <td>NUMERODISCO</td>
    <td>INTERPRETE</td>
  </tr>
  <%for (CancionEntity cancion:canciones) {%>
  <tr>
    <td><%=cancion.getId()%></td>
    <td><%=cancion.getNombre()%></td>
    <td><%=cancion.getDuracion()%></td>
    <td><%=cancion.getPista()%></td>
    <td><%=cancion.getNumerodisco()%></td>
    <td><%for (InterpreteEntity interprete:interpretes){
        if (interprete.getId()==cancion.getInterprete()){
            out.print(interprete.getNombre());
    }}%></td>
  </tr>
  <%}%>
</table>

</body>
</html>
