$("document").ready(function()
{
	alert("funcionando bien jquery");
	$("#menu_main li").click(function()
	{
		$("#menu_main li").removeClass("selected").addClass("unselected");
		desplegarMenuSecundario($(this).html());
		setSelected(this);

	});














});


function desplegarMenuSecundario(menuPrincipal)
{
console.log("despliega:"+menuPrincipal);
	switch(menuPrincipal)
	{

		case "Gestion de Empleados":
		console.log("seleccion 1");
		$("#menu_lat").html("<ul><li class=\"unselected\">Ver  Empleados</li><li class=\"unselected\" >Crear Empleado</li><ul>")
		break;

		case "Gestion Menu":
		console.log("seleccion 2");
		$("#menu_lat").html("<ul><li class=\"unselected\">Ver  Entradas</li><li class=\"unselected\" >Crear Entrada</li> <li class=\"unselected\" >Editar Entrada</li><ul>")
		
		break;
		
		case "Gestion Mesas":
		$("#menu_lat").html("<ul><li class=\"unselected\">Ver  Mesas</li><li class=\"unselected\" >Crear Mesa</li><ul>")
		
		console.log("seleccion 3");
		break;
		
		case "Gestion de Empleados":
		console.log("seleccion 4");
		break;
		

	}
}

function setSelected(opcion)
{

	$(opcion).addClass( "selected" ).removeClass("unselected");
}