<%@ page import="es.uma.taw.bank.entity.MensajeEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: probl
  Date: 24/04/2023
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
List <MensajeEntity> mensajescliente = (List<MensajeEntity>) request.getAttribute("mensajescliente");
%>

<h1>Asistencia virtual</h1>

<form action="/asistencia/chat" method="post">
    Introduzca su consulta:<br/> <textarea name="mensaje" size="500" maxlength="500" rows="10" cols="50"> </textarea>
    <input type="submit" value="Enviar">
</form>


</body>
</html>
