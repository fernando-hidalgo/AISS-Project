<%@page import="aiss.model.resources.TumblrResource"%>
<%@page import="aiss.model.Tumblr.BlogInfo.BlogInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>

	<h1>Tumblr results for <c:out value="${requestScope.name}"></c:out></h1>

	<fieldset id="Text">
		<legend>Texts:</legend>
		<c:forEach items="${requestScope.PText}" var="postText">
			<span>Blog: <c:out value="${postText.blogName}" /></span><br />
			<span>Title: <c:out value="${postText.title}"></c:out></span><br />
			<p><c:out value="${postText.body}"></c:out></p><br />
			<a href='<c:out value="${postText.postUrl}"></c:out>'>Acceder al contenido completo</a><br />
		</c:forEach>
	</fieldset>
	
	<fieldset id="Photo">
		<legend>Photos:</legend>
		<c:forEach items="${requestScope.PPhoto}" var="postPhoto">
			<span>Blog: <c:out value="${postPhoto.blogName}"></c:out></span><br />
			<span><c:out value="${postPhoto.summary}"></c:out></span><br />
			<a href='<c:out value="${postPhoto.postUrl}"></c:out>'>Acceder al contenido completo</a><br />
			<c:forEach items="${postPhoto.photos}" var="photo">
				<img src='<c:out value="${photo.originalSize.url}"></c:out>' style="height:200px;width:auto-size"> <br />
			</c:forEach>	
		</c:forEach>
	</fieldset>
	
	<fieldset id="Video">
		<legend>Videos:</legend>
		<c:forEach items="${requestScope.PVideo}" var="postVideo">
			<span>Post: <c:out value="${postVideo.postUrl}"></c:out></span>	<br />		
		</c:forEach>
	</fieldset>
</body>
</html>