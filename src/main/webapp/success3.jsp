<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo_steam.css">
<title>Informacion de la Tienda</title>
</head>
<body>

<div class="header">
  <a  class="logo"><img src="images/logo_steam.png" alt="Trulli" width="50" height="50">Tienda de Steam</a>
</div>


<div class="column">
<span><img src="https://steamcdn-a.akamaihd.net/steam/apps/${requestScope.id}/header.jpg" alt=""></span><br/>
</div>

<fieldset class="field_set">
<legend>Datos</legend>
<span>Titulo: <c:out value="${requestScope.nombre}"/></span><br/>
<span>Desarrollador: <c:out value="${requestScope.developer}"/></span><br/>
<span>Reviews Positivas: <c:out value="${requestScope.reviews_positivas}"/></span><br/>
<span>Reviews Negativas: <c:out value="${requestScope.reviews_negativas}"/></span><br/>
<span>Propietarios: <c:out value="${requestScope.propietarios}"/></span><br/>
<span>Precio: <c:out value="${requestScope.precio}"/></span><br/>
<span>Generos: <c:out value="${requestScope.generos}"/></span><br/>
<span>Idiomas: <c:out value="${requestScope.idiomas}"/></span><br/>
</fieldset>

<fieldset id="field2" style="width:500px">
<legend>Ultimas Noticias</legend>
<c:forEach items="${requestScope.lista_noticias}" var="lista">
	<span><c:out value="${lista.title}"/></span><br/>
</c:forEach>
</fieldset>

<fieldset style="width:300px" class="field_set">
<legend>Porcetajes Logros Mas/Menos Obtenidos</legend>
	<p>
	<span>Logro: <c:out value="${requestScope.nombre_mas_porc}"/></span><br/>
	<span>Obtención: <c:out value="${requestScope.numero_mas_porc}"/></span><br/>
	</p>
	<p>
	<span>Logro: <c:out value="${requestScope.nombre_menos_porc}"/></span><br/>
	<span>Obtención: <c:out value="${requestScope.numero_menos_porc}"/></span><br/>
	</p>
</fieldset>
<form id="busq_steam" action="GameController" method="post">
    <input type="submit" name="siguiente_twitch" value="Ir a Twitch">
</form>
</body>
</html>





