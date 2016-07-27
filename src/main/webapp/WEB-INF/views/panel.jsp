<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head><title>hola</title></head>
<body>

bienvenido <%out.println("usuario:"+request.getAttribute("Usuario")); %>

el menu es:

<%out.println("menu:"+request.getAttribute("opcionesMenu")); %>
</body>
	

</html>