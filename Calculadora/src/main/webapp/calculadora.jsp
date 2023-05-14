<%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 08/02/2023
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
  if(request.getAttribute("result") != null) {
    resultado = (double) request.getAttribute("result");
  }
%>

<h1>Introduzca los datos:</h1>
El resultado es: <%=resultado%>
<form action="hello-servlet" method="post">
  <h1>Operando1: <input name="operando1" type="text" value= "<%=resultado%>"></h1>
  <h1>Operando2: <input name="operando2" type="text"></h1>
  <h1>Operacion:
    <input type="radio" name="operacion" value="+">+
    <input type="radio" name="operacion" value="-">-
    <input type="radio" name="operacion" value="*">*
    <input type="radio" name="operacion" value="/">/
  </h1>
  <input type="submit"/>
</form>
</body>
</html>
