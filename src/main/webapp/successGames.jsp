<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styleTwitch.css">
<title>Search results</title>
</head>
<body>
<img class="Logo" alt="twitch" src="images/logoTwitch2.png" width="80px" height="80px">
<img class="letrasLogo" alt="twitch" src="images/letrasTwitch.webp" width="300px" height="120px"> <br/>

<form id="botonTumblr" action="SearchByTagController" method="post">
			<input type="submit" name="botonTumblr" title="obtener" value="obtener">			
</form>
<h1 style="font-family: verdana;color: #CCE;">Datos del juego buscado: </h1>
<div class="datos" style="max-width:70%;max-heigth:25%" >

<fieldset  id="game" >
<legend>Juego: <c:out value="${requestScope.datosApi}"/></legend>


		
<c:forEach items="${requestScope.datosGame}" var="datos">
	
	<span>Id del juego: <c:out value="${datos.id}"/></span><br/>
	<span>Nombre del juego: <c:out value="${datos.name}"/></span><br/>
	<span> <img alt="Sin foto" src="${datos.boxArtUrl}" /> </span><br/>
	
</c:forEach>
</fieldset>
</div>


<div class="stream" style="max-width:25%;max-heigth:25%;width: 25%;">

<h3 style="font-family: verdana;">Streamings del juego:  <c:out value="${requestScope.datosApi}"/> </h3> <br/>
<c:forEach items="${requestScope.datosStream}" var="datos">
	
	<span class= 'user'><c:out value="${datos.userName}"/></span><br/><br/>
	<span class= 'titulo'><c:out value="${datos.title}"/></span><br/><br/>
	<iframe
    src=  <c:out value="https://player.twitch.tv/?channel="/><c:out value="${datos.userName}"/><c:out value="&parent=streamernews.example.com&muted=true&autoplay=false"/>
    height="200"
    width="300"
    frameborder="0"
    scrolling="yes"
    allowfullscreen="true">
	</iframe><br/>
	<span>Lo están viendo <c:out value="${datos.viewerCount}"/> personas</span><br/>
	<span type="date"><c:out value="${datos.startedAt}"/></span><br/><br/><br/>
	
	
</c:forEach>

</div>

<div class="video"  style="max-width:25%;max-heigth:25%;width: 25%;" >
<h3 style="font-family: verdana;">Vídeos más vistos del juego:  <c:out value="${requestScope.datosApi}"/> </h3> <br/>
<c:forEach items="${requestScope.datosVideosTop}" var="datos">
	
	
	<span class= 'user'><c:out value="${datos.userName}"/></span><br/><br/>
	<span class= 'titulo'><c:out value="${datos.title}"/></span><br/><br/>
	
	<iframe
    src=  <c:out value="https://player.twitch.tv/?video="/><c:out value="${datos.id}"/><c:out value="&parent=streamernews.example.com&muted=true&autoplay=false"/>
    height="200"
    width="300"
    frameborder="0"
    scrolling="no"
    allowfullscreen="true">
	</iframe><br/><br/>
	
	<span> <c:out value="${datos.viewCount}"/> visualizaciones</span><br/><br/><br/>
	
	
	
</c:forEach>
</div>


  <div class="uVideo"  style="max-width:25%;max-heigth:25%;width: 23%;" > 

<h3 style="font-family: verdana;">Últimos vídeos del juego:  <c:out value="${requestScope.datosApi}"/> </h3><br/> 
<c:forEach items="${requestScope.datosVideos}" var="datos">
	
	<span class='user'><c:out value="${datos.title}"/></span><br/><br/>
	<span class='titulo'><c:out value="${datos.userName}"/></span><br/><br/>
	
	<a href=<c:out value="${datos.url}"/>>Ir al vídeo en Twitch </a><br/><br/>
	
	<span><c:out value="${datos.viewCount}"/> visualizaciones</span><br/><br/><br/>
	
	
	
</c:forEach>
</div>


<div class="clip"  style="max-width:25%;max-heigth:25%;width: 23%;">
<h3 style="font-family: verdana;">Clips del juego: <c:out value="${requestScope.datosApi}"/></h3><br/>
<c:forEach items="${requestScope.datosClip}" var="datos">

	<span class='user'><c:out value="${datos.title}"/>  </span><br/><br/>
	<span class='titulo'><c:out value="${datos.broadcasterName}"/>  </span><br/><br/>
	<span>Creador del clip: <c:out value="${datos.creatorName}"/>  </span><br/><br/>
	<a href=<c:out value="${datos.url}"/>>Ir al clip en Twitch </a><br/><br/>
	<span><c:out value="${datos.viewCount}"/> visualizaciones </span><br/><br/><br/>
	
</c:forEach>
</div>
</body>
</html>

