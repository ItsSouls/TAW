<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 8/2/23
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    double resultado = 0.0;
    if (request.getAttribute("result") != null) {
        resultado = (double) request.getAttribute("result");
    }
%>
<h1>Introduzca los datos:</h1>

El resultado es: <%= resultado %>

<form method="post" action="CalculadoraConJSP">
    Operando1: <input type="text" name="op1" value="<%= resultado %>"><br/>
    Operando2: <input type="text" name="op2"><br/>
    Operación:<br/>
    <input type="radio" name="operacion" value="+"> +<br/>
    <input type="radio" name="operacion" value="-"> -<br/>
    <input type="radio" name="operacion" value="*"> *<br/>
    <input type="radio" name="operacion" value="/"> /<br/>

    <input type="submit" value="Enviar">
</form>
</body>
</html>
