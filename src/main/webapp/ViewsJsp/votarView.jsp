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
	document.getElementById("pregunta").selectedIndex= document.getElementById("tema").selectedIndex;
  
}
function preguntaSeleccionada()  {
	 document.getElementById("tema").selectedIndex=document.getElementById("pregunta").selectedIndex;
  
}

</script>
</head>
<body>
	<h1>
		Vista de <b>Votar</b>
	</h1>
	<c:set var="vView" scope="request" value="${votar}" />
	<div>${vView.update()}</div>
	<form action="/JEE_ECP/jsp/votar" method="post">
		<div>Temas:</div>
		 <select name="tema" id="tema" onchange="temaSeleccionado();">
		   <c:forEach var="tema" items="${vView.temas}">
					<option value="${tema.id}" id="${tema.id}" >${tema.descripcion}</option>
		</c:forEach>
		</select>
		 <label>Pregunta:</label>
		
	    <select  id="pregunta" style="-webkit-appearance: none; -moz-appearance: none; appearance: none;" onchange="preguntaSeleccionada()">
		     <c:forEach var="tema" items="${vView.temas}">
                    <option value="${tema.id}" id="${tema.id}" name="${tema.id}">${tema.pregunta}</option>
        </c:forEach>
		</select>
		<div>
		<label>Nivel Estudios:</label>
		<select name="nivelEstudios" id="nivelEstudios">
           <c:forEach var="nivel" items="${vView.nivelesEstudio}">
                     <option value="${nivel}" id="${nivel}" >${nivel}</option>
                    <c:set var="selec" value="" ></c:set>
          </c:forEach>
        </select>
        </div>
		
	    <p> 
	        <label>Valoraci&oacute;n: </label>
			<input type="text" value="0" name="valoracion" id="valoracion"/>
		</p>
		
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
	     
		
			
	</p>		
	<p>
        <a href="/JEE_ECP/jsp/home">Home jsp</a>
    </p>
</body>
</html>
