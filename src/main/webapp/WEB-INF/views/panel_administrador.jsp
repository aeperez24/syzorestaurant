<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/javascript/jquery.js"></script>

<script type="text/javascript" src="/resources/javascript/menu.js"></script>
<head><title>Menu de administrador</title></head>
<body>
<div id="bienvenida">
Bienvenido: <%out.println(request.getAttribute("Usuario")); %>
</div>
<div id="menu_main">
<li  class="unselected">Gestion de Empleados</li>

<li class="unselected">Gestion Menu</li>

<li class="unselected">Gestion Mesas</li>

<li class="unselected">Cerrar Sesion</li>
</div>
<div id="main_area">

<div id="menu_lat">
<ul>

</ul>

</div>
</div>
</body>
	

</html>