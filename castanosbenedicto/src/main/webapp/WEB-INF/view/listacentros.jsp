<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.junio2023.entity.CentroEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<CentroEntity> listacentros = (List<CentroEntity>) request.getAttribute("listacentros");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Listado de centros</h1>
    <form:form action="/enviar" method="post">
        <%for (CentroEntity centro:listacentros){%>
        <input type="radio" name="radios" value="<%=centro.getIdcentro()%>"><%=centro.getNombre()%><br>
        <%}%>
        <input type="submit" value="Enviar"/>
    </form:form>
</body>
</html>