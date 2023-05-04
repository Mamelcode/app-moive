<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLIXFIX</title>
	<link href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro-v6@44659d9/css/all.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/resource/css/initial.css" />
	<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
	<link rel="stylesheet" href="/resource/css/style.css" >
</head>
<body>

	<!-- 탑 메뉴 -->
	<nav class="header">
		<div class="topmenu">
			<ul class="toplist">
				<li class="toplogo">
				<a href="/main/list">
				<i class="fa-duotone fa-camera-movie" style="--fa-primary-color: #ffffff; --fa-secondary-color: #ff0000; --fa-secondary-opacity: 1;"></i>
					<span style="color: #fff">FLIXFIX</span>
					</a>
					</li>
				<li><a href="/main/postlist">커뮤니티</a></li>
				<li><a href="/main/mylist">관심목록</a></li>
			</ul>
			<ul class="topsearch">
				<li><span>${logonUser.name} 님</span><a href="/logout">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<!-- 탑 메뉴  끝 -->
	
	  <div class="list_wrap">
	  
	  
	  
    <div class="width">
      <h2 class="title">관심영화</h2>
      <div class="list_page">
      <!-- 영화 찜목록 -->
      	<c:forEach items="${iikeMovie }" var="m">
        	<div class="list_box">
          		<a href="/main/detail?movieId=${m.movieId}"><img src="https://image.tmdb.org/t/p/w300/${m.posterURL }"></a>
        	</div>
        	<a href="/detail/movie-unlike?movieId=${m.movieId }&position=mylist"style="color: green;"> ✔</a>
        </c:forEach>
	   </div>
    </div>
	
	<div class="width">
      <h2 class="title">관심배우</h2>
      <div class="list_page">
        <!-- 배우 찜목록 -->
      	 <c:forEach items="${likeActor }" var="a">
        	<div class="list_box">
          		<img src="https://image.tmdb.org/t/p/w300/${a.posterURL }">
        	</div>
        	<a href="/detail/actor-unlike?actorId=${a.actorId }&position=mylist"style="color: green;"> ✔</a>
        </c:forEach>
        

      </div>
    </div>
	
	
	 <div class="width">
      <h2 class="title">관심감독</h2>
      <div class="list_page">

        <!-- 감독 찜목록 -->
      	 <c:forEach items="${likeDirector }" var="d">
      	 	<c:choose>
      	 		<c:when test="${d.posterURL eq null}">
      	 			<div class="list_box">
      	 				<img src="/resource/img/noimg.gif">
      	 			</div>
        		</c:when>
        		<c:otherwise>
        			<div class="list_box">
          				<img src="https://image.tmdb.org/t/p/w300/${d.posterURL }">
        			</div>
        		</c:otherwise>
        	</c:choose>
        	<a href="/detail/director-unlike?directorId=${d.directorId }&position=mylist"style="color: green;"> ✔</a>
        </c:forEach>
        

      </div>
    </div>
	
    
  </div>

  </body>
</html>