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


	<fieldset id="UserInfo">
		<legend> Tumblr: </legend>
		<img src='<c:out value="${requestScope.Avatar}"></c:out>'> <br />
		<span>User: <c:out value="${requestScope.User.name}" /></span> <br />
		<span>You likes <c:out value="${requestScope.User.likes}"></c:out> posts</span><br /> 
		<span>Your Total Posts: <c:out value="${requestScope.totalPosts}"></c:out></span>
	</fieldset>
	
	<fieldset id="Followers">
		<legend>Your Followers:</legend>
		<span>Total Followers: <c:out value="${requestScope.totalFollowers}"></c:out></span><br />
			<c:forEach items="${requestScope.Followers}" var="name">
				<fieldset>
					<span>Name: <c:out value="${name}"></c:out></span>
				</fieldset>
			</c:forEach>
	</fieldset>
	
	<fieldset id="Followings">
		<legend> Your Followings:</legend>
		<span>Total Followings: <c:out value="${requestScope.Followings.totalBlogs}"></c:out></span>
		<c:forEach items="${requestScope.Followings.blogs}" var="blog">
		<fieldset>
		<span>Name: <c:out value="${blog.name}"></c:out></span><br />
		<span>Blog Title: <c:out value="${blog.title}"></c:out></span><br />
		</fieldset> <br />
		</c:forEach>
	</fieldset>
</body>
</html>