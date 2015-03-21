<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VerVotacionesView</title>
</head>
<body>
	<h1>
		Vista de <b>Ver Votaciones</b>
	</h1>
	<c:set var="vView" scope="request" value="${verVotaciones}" />
	<div>${vView.update()}</div>
	<table>
	   <tr>
	      <th>Descripción</th>
	      <th>Pregunta</th>
	      <th>Votos</th>
	   </tr>
	   <c:forEach var="temaSuma" items="${vView.votosPorTemas}">
      <tr>
          <td>${temaSuma.tema.descripcion}</td>
          <td>${temaSuma.tema.pregunta}</td>
          <td>${temaSuma.suma}</td>
       </tr>   
     </c:forEach>
	</table>
	
	<table>
       <tr>
          <th>Nivel</th>
          <th>Media</th>
       
       </tr>
       <c:forEach var="mediaNivel" items="${vView.mediasPorNivel}">
      <tr>
          <td>${mediaNivel.nivelEstudio}</td>
          <td>${mediaNivel.media}</td>
        
       </tr>   
     </c:forEach>
    
    </table>
   
	<p>
        <a href="/ECP/jsp/home">Home jsp</a>
    </p>
</body>
</html>
