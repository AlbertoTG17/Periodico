<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
	    Materialize.updateTextFields();
	    $('select').material_select();
	  });
</script>
</head>
<body>

	<div style="padding: 0 30%" align="center">
	
		<h2>Añadir noticia</h2>
	
		<form method="post" action="Publicar">
		
			<div class="input-field col s6">
	          <input id="email" type="text" class="validate" name="email">
	          <label for="email">Email</label>
	        </div>
	
			<div class="input-field col s12">
				<select name="categoria">
					<option value="" disabled selected>Choose your option</option>
					<option value="1">Deportes</option>
					<option value="2">Cotilleos</option>
					<option value="3">Politica</option>
				</select>
			</div>
			
			<div class="input-field col s6">
	          <input id="titulo" type="text" class="validate" name="titulo">
	          <label for="titulo">Titulo</label>
	        </div>
	        
	        <div class="input-field col s12">
	          <textarea id="contenido" class="materialize-textarea" name="contenido"></textarea>
	          <label for="contenido">Contenido</label>
	        </div>
	
			<button class="btn waves-effect waves-light" type="submit" name="action">
				Publicar <i class="material-icons right">send</i>
			</button>
		
		</form>
	</div>

</body>
</html>