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

	  <div class="detail_wrap">
    <div class="width detail_top">
      <div class="detail_poster">
        <img src="https://image.tmdb.org/t/p/w400/${moviedetail.poster_path }">
        <div class="detail_star">
        
		<h4>한줄평</h4>
		<form class="" action="/detail/comment-create" method="post">
			<input type="hidden" name="movieId" value="${param.movieId}">
			<input type="text" name="comments" value="">
			<button type="submit" name="button">
				<i class="fa-regular fa-paper-plane"></i> 작성
			</button>
		</form>
		
		<!-- 한줄평 영역(comment) -->
		<c:forEach items="${commentList }" var="c" >
			<p style="display: flex; justify-content: space-between;" ><i class="fa-solid fa-message-smile"></i>${c.comments }
			<!-- 로그인 유저와 작성한 유저가 같을 때 -->
			<c:if test="${logonUser.id eq c.id }">
			<a href="/detail/comment-delete?commentId=${c.commentId }&movieId=${c.movieId}&id=${c.id}" style="color: white;">삭제</a>
			</c:if>
			</p>
		</c:forEach>
		
        </div>
      </div>
      <!-- 영화 상세보기 영역(moviedetail)  -->
      <div class="detail_text">
        <h2>${moviedetail.title }
        
        <c:choose>
	        <c:when test="${movieLike}">
	       		 <a href="/detail/movie-unlike?movieId=${moviedetail.id }&position=detail" class="active">
	       		 <i class="fa-regular fa-check"></i></a>
	  		</c:when>
	  		
	        <c:otherwise>
	      	   <a href="/detail/mylist-movie?movieId=${moviedetail.id}&posterURL=${moviedetail.poster_path}&movieName=${moviedetail.title}">
	       		 <i class="fa-solid fa-plus"></i></a> 
	        </c:otherwise>
        </c:choose>
        </h2>
        
        <h3>${moviedetail.tagline }</h3>
        <p>${moviedetail.overview }</p>
        <div class="detail_direc">
        
          <h4>감독</h4>
			<c:forEach items="${director}" var="d">
				<c:choose>
					<c:when test="${d.profile_path eq null}">
						<img src="/resource/img/noimg.gif">
						<span>${d.name }</span> 
					</c:when>
					<c:otherwise>
						<img src="https://image.tmdb.org/t/p/w200/${d.profile_path }">
						<span>${d.name }</span>
					</c:otherwise>
				</c:choose>
				
					<c:choose>
						<c:when test="${d.like}">
							<div>
								<a href="/detail/director-unlike?movieId=${param.movieId}&directorId=${d.id}&position=detail"
									style="color: green;"> ✔</a>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<a href="/detail/mylist-director?movieId=${param.movieId}&directorId=${d.id}&posterURL=${d.profile_path}&directorName=${d.name}"
									style="color: red;"> ❤ </a>
							</div>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
		</div>
		
        <div class="detail_actor">
          <h4>배우</h4>
          <ul>
          	<c:forEach items="${actorList }" var="a">
	            <li><img src="https://image.tmdb.org/t/p/w300/${a.profile_path }">
	            <span>${a.name }</span></li>
	            
					<c:choose>
						<c:when test="${a.like}">
							<div>
								<a href="/detail/actor-unlike?movieId=${param.movieId}&actorId=${a.id}&position=detail"
									style="color: green;"> ✔</a>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<a href="/detail/mylist-actor?movieId=${param.movieId}&actorId=${a.id}&posterURL=${a.profile_path}&actorName=${a.name}"
									style="color: red;"> ❤ </a>
							</div>
						</c:otherwise>
					</c:choose>
					
			</c:forEach>
          </ul>
         
        </div>
        
        <!-- 예고편 영역 (유튜브) -->
        <div class="de_youtube">
          <iframe width="980" height="550" src="https://www.youtube.com/embed/${presult }" title="YouTube video player" frameborder="0" 
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </div>
        
      </div>
    </div>

  </div>


</body>
</html>