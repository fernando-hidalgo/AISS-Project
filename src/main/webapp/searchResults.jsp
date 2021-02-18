<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    $(document).ready(function(){
        $('input:checkbox').click(function() {
            $('input:checkbox').not(this).prop('checked', false);
        });
    });
</script>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <img id ="socialStatsYT"src="images/SocialStatsYoutube.png" alt="SocialStatsYT">
        <h1>Elige que video quieres añadir a la playlist</h1>
        <form action="/Playlist" method="get">
                <c:forEach items="${requestScope.videos}" var="video">
                    <c:choose>
                        <c:when test="${video.id.kind == 'youtube#channel'}">
                            <div class="canal">
                                    <h1>Canal: <c:out value ="${video.snippet.title}"></c:out></h1>
                                    <img id="profilePic"src="${video.snippet.thumbnails.high.url}">           
                            </div>   
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li>
                                    <label class="video">
                                    <p><c:out value="${video.snippet.title}"></c:out></p>
                                    <input type="radio" id="${video.snippet.title}" name="videoID" value ="${video.id.videoId}"/>
                                    <img src="${video.snippet.thumbnails.high.url}">
                                    </label>
                                </li>
                                <li>
                                    <iframe id="player" type="text/html" width="300" height="200"
                                    src="http://www.youtube.com/embed/${video.id.videoId}"
                                    frameborder="0">
                                    </iframe>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <br>
                <input type="submit" value="Enviar">
                <c:out value="${requestScope.nombre_juego}"></c:out>
        </form>
    </body>
</html>