<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>PreEliminarView</title>
</head>
<body>
    <h1>
        Vista de <b>Pre-Eliminar</b>
    </h1>
    <c:set var="vView" scope="request" value="${preeliminar}" />
    <div>${vView.update()}</div>
    <form action="/ECP/jsp/preeliminar" method="post">
        
        
        </div>
        <p> 
           <label> Clave Borrado:</label><input type="text" value="${vView.claveBorrado}" name="claveBorrado" id="claveBorrado"/>
        </p>
               
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
