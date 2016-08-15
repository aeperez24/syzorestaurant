<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="StyleSheet" href="/resources/css/style.css" />


	<title>Inicio de sesion</title>
</head>
<body>
	<div class="h_center">
		<form:form method="POST" action="inicioSession" class="v_center" id="loginform" >

			<input id="usuario" type="text" placeholder="Usuario" size="25" name="username" class="block h_center"></input>
			<input id="psw" type="password" placeholder="Password" size="25" name="password" class="block h_center"></input>
			<div class="h_center">
			<input class="BT1  " type="submit" value="Aceptar"/>
			</div>

		</form:form>


	</div>

</body>
</html>