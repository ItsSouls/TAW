<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 16/04/2023
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planeta</title>
</head>
<body>
<form:form modelAttribute="especies" method="post" action="/guardar">
    <form:hidden path="especieId"/>
        Nombre: <form:input path="especie"/><br>
        Peso Medio: <form:input path="pesoMedio"/><br>
        Esperanza de Vida: <form:input path="esperanzaVida"/><br>
        Idioma: <form:input path="idioma"/><br>
        Familia: <form:radiobuttons path="clasificacion" items="${familias}" itemLabel="familia" itemValue="familiaId"/><br>
        <form:button>Guardar</form:button>
</form:form>

</body>
</html>
