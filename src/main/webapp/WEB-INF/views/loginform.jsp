<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Inicio de sesion</title>
</head>
<body>
	<div>
		<form:form method="POST" action="inicioSession" >

			<input id="usuario" type="text" placeholder="Usuario" size="25" name="username"></input>
			<input id="psw" type="password" placeholder="Password" size="25" name="password"></input>
			<input type="submit" value="Aceptar"/>
			<button>reestablecer</button>

		</form:form>


	</div>

</body>
</html>