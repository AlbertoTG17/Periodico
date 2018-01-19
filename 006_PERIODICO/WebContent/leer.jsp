<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Periodico</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

</head>
<body>

	<div align="center">

		<h2>LEER NOTICIAS</h2>
		
		<a href="Consultar">Consultar noticias</a> <br/><br/>
		<a href="insertar.jsp">Añadir noticia</a> <br/><br/>
		
		<table class="bordered">
		
		<%
			String resultado = (String)session.getAttribute("resultado");			
			if(resultado != null){	
				out.println("<thead><tr><th>Email</th><th>Titular</th><th>Contenido</th><th>Fecha</th></tr></thead>");
				out.println(resultado);
			}
		%>
		
		</table>
	</div>

</body>
</html>