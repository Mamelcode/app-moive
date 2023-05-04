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
				<li>
					<div class="box">
						<div class="container-2">
							<span class="icon"><i class="fa fa-search"></i></span> <input
								type="search" id="search" placeholder="Search...">
						</div>
					</div>
				</li>
			</ul>
			<ul class="topsearch">
				<li><span>${logonUser.name} 님</span><a href="/logout">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<!-- 탑 메뉴  끝 -->
	
	<div class="list_wrap">
    <div class="width">
      <h2 class="title">인기순</h2>

      <div class="swiper firstSwiper">
        <div class="swiper-wrapper">
        <!-- 인기순 영역 -->
        <c:forEach items="${popular}" var="p">
          <div class="swiper-slide list_box">
            <a href="/main/detail?movieId=${p.id}"><img src="https://image.tmdb.org/t/p/w300/${p.poster_path}"></a>
          </div>
        </c:forEach>
        
        </div>
      </div>
      <div class="swiper-btn">
        <div class="swiper-prev"><i class="fa-solid fa-chevron-left"></i></div>
        <div class="swiper-next"><i class="fa-solid fa-chevron-right"></i></div>
      </div>
    </div>
  </div>

  <div class="list_wrap">
    <div class="width">
      <h2 class="title">평점순</h2>

      <div class="swiper secondSwiper">
        <div class="swiper-wrapper">
        <!-- 평점순 영역 -->
         <c:forEach items="${topRated }" var="t" >
          <div class="swiper-slide list_box">
            <a href="/main/detail?movieId=${t.id}"><img src="https://image.tmdb.org/t/p/w300/${t.poster_path }"></a>
          </div>
          </c:forEach>
          
         </div>
      </div>
      <div class="swiper-btn2">
        <div class="swiper-prev2"><i class="fa-solid fa-chevron-left"></i></div>
        <div class="swiper-next2"><i class="fa-solid fa-chevron-right"></i></div>
      </div>
    </div>
  </div>

  <div class="list_wrap">
    <div class="width">
      <h2 class="title">현재상영중</h2>

      <div class="swiper thirdSwiper">
        <div class="swiper-wrapper">
          <!-- 현재상영중 영역 -->
         <c:forEach items="${nowPlaying }" var="n">
          <div class="swiper-slide list_box">
            <a href="/main/detail?movieId=${n.id}"><img src="https://image.tmdb.org/t/p/w300/${n.poster_path }"></a>
          </div>
         </c:forEach>
         
        </div>
      </div>
      <div class="swiper-btn2">
        <div class="swiper-prev3"><i class="fa-solid fa-chevron-left"></i></div>
        <div class="swiper-next3"><i class="fa-solid fa-chevron-right"></i></div>
      </div>
    </div>
  </div>

  	<script src="https://cdn.jsdelivr.net/npm/swiper@7/swiper-bundle.min.js"></script>
	<script>
		var swiper = new Swiper(".firstSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next",
				prevEl : ".swiper-prev",
			},
		});
	</script>
	<script>
		var swiper = new Swiper(".secondSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next2",
				prevEl : ".swiper-prev2",
			},
		});
	</script>
	<script>
		var swiper = new Swiper(".thirdSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next3",
				prevEl : ".swiper-prev3",
			},
		});
	</script>

</body>

</html>