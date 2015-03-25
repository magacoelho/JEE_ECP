<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AgregarView</title>
</head>
<body>
	<h1>
		Vista de <b>Agregar Tema</b>
	</h1>
	
    <form action="/JEE_ECP/jsp/agregar" method="post">
        <p>Temas:</p>
        <p> 
            <label> Descripción:</label><input type="text" value="" name="descripcion" id="descripcion"/>
        </p>
        <p> 
           <label> Pregunta:</label><input type="text" value="" name="pregunta" id="pregunta"/>
        </p>
        <p>
            <input type="submit" value="Enviar" />
        </p>
    </form>
    <p>
        <a href="/JEE_ECP/jsp/home">Home jsp</a>
    </p>
</body>
</html>
