<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>EliminarView</title>
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
        Vista de <b>Eliminar</b>
    </h1>
    <c:set var="vView" scope="request" value="${eliminar}" />
    <div>${vView.update()}</div>
    <form action="/ECP/jsp/votar" method="post">
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
        
        </div>
               
        <p>
            <input type="submit" value="Enviar" />
        </p>
    </form>
    <p>
         
        
            
    </p>        
    <p>
        <a href="/ECP/jsp/home">Home jsp</a>
    </p>
</body>
</html>
