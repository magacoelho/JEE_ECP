<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VotarView</title>

<script>
function temaSeleccionado() {
    var x = document.getElementById("nivelEstudios").selectedIndex;
    return x;
  
}

</script>
</head>
<body>
	<h1>
		Vista de <b>Votar</b>
	</h1>
	<c:set var="vView" scope="request" value="${votar}" />
	<div>${vView.update()}</div>
	<form action="/ECP/jsp/votar" method="post">
		<p>Temas:</p>
		 <select name="tema" id="tema">
		   <c:forEach var="tema" items="${vView.temas}">
					<option value="${tema.id}" id="${tema.id}" name="${tema.id}">${tema.descripcion}</option>
				</c:forEach>
		</select>
		<label>Nivel Estudios:</label>
		 <select name="nivelEstudios" id="nivelEstudios">
		   <c:forEach var="tema" items="${vView.temas}">
		            
					<option value="${tema.id}" id="${tema.id}" name="${tema.id}">${tema.descripcion}</option>
					<c:set var="selec" value="" ></c:set>
		  </c:forEach>
		  <!--<c:set var="temaSel" value="if ${tema}"></c:set>-->
		</select>
		
	    <p> 
	        <label>Valoraci&oacute;n: </label>
			<input type="text" value="0" name="valoracion" id="valoracion"/>
		</p>
		 <p> 
			<input type="hidden" value="" name="ip" id="ip"/>
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
	      <label>Pregunta:</label>
		
			<label name="pregunta" id="pregunta">${vView.temas[nivelEstudiosSelected].pregunta} </label>
	</p>		
	<p>
        <a href="/ECP/jsp/home">Home jsp</a>
    </p>
</body>
</html>
