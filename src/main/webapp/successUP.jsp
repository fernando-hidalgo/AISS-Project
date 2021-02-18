<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>


	<fieldset id="UserPosts">
		<legend>
			Tumblr search for
			<c:out value="${param.UserQuery}" />
		</legend>
		<c:forEach items="${requestScope.UserPosts.posts}" var="post">
			<span>Post: <c:out value="${post.postUrl}" /></span>
			<br />
		</c:forEach>
	</fieldset>
</body>
</html>