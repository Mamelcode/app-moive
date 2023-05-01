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
				<li><span>${logonUser.name}님</span><a href="/user/logout" style="color: #C0FFFF;">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<!-- 탑 메뉴  끝 -->

	<!-- 첫번째 슬라이드 시작 -->
	<div class="list_wrap">
		<div class="width">
			<h2 class="title">인기순</h2>
			<div class="swiper firstSwiper">
				<div class="swiper-wrapper">
					<c:forEach items="${popular}" var="pop">
						<div class="swiper-slide list_movie">
							<a href="/main/detail?movieId=${pop.id}"><img src="https://image.tmdb.org/t/p/w300/${pop.poster_path}"></a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="swiper-btn">
				<div class="swiper-prev"><i class="fa-solid fa-chevron-left"></i>
				</div>
				<div class="swiper-next"><i class="fa-solid fa-chevron-right"></i>
				</div>
			</div>
		</div>
	</div>
	<!-- 첫번째 슬라이드 끝 -->

	<!-- 두번째 슬라이드 시작 -->
	<div class="list_wrap">
		<div class="width">
			<h2 class="title">평점순</h2>
			<div class="swiper secondSwiper">
				<div class="swiper-wrapper">
					<c:forEach items="${topRate}" var="top">
						<div class="swiper-slide list_movie">
							<a href="/main/detail?movieId=${top.id}"><img src="https://image.tmdb.org/t/p/w300/${top.poster_path}"></a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="swiper-btn2">
				<div class="swiper-prev2"><i class="fa-solid fa-chevron-left"></i>
				</div>
				<div class="swiper-next2"><i class="fa-solid fa-chevron-right"></i>
				</div>
			</div>
		</div>
	</div>
	<!-- 두번째 슬라이드 끝 -->

	<!-- 세번째 슬라이드 시작 -->
	<div class="list_wrap">
		<div class="width">
			<h2 class="title">현재상영중</h2>
			<div class="swiper thirdSwiper">
				<div class="swiper-wrapper">
					<c:forEach items="${nowPlaying}" var="now">
						<div class="swiper-slide list_movie">
							<a href="/main/detail?movieId=${now.id}"><img src="https://image.tmdb.org/t/p/w300/${now.poster_path}"></a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="swiper-btn2">
				<div class="swiper-prev3"><i class="fa-solid fa-chevron-left"></i>
				</div>
				<div class="swiper-next3"><i class="fa-solid fa-chevron-right"></i>
				</div>
			</div>
		</div>
	</div>
	<!-- 세번째 슬라이드 끝 -->
	
	 <!-- 네번째 슬라이드 시작 -->
	 <c:if test="${similarList != null}">
		<div class="list_wrap">
			<div class="width">
				<h2 class="title"><b>${movieName}</b> 작품과 비슷한 장르 작품을 추천 받아보세요!</h2>
				<div class="swiper fourthSwiper">
					<div class="swiper-wrapper">
						<c:forEach items="${similarList}" var="s">
							<div class="swiper-slide list_movie">
								<a href="/main/detail?movieId=${s.id}"><img src="https://image.tmdb.org/t/p/w300/${s.poster_path}"></a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="swiper-btn2">
					<div class="swiper-prev4"><i class="fa-solid fa-chevron-left"></i>
					</div>
					<div class="swiper-next4"><i class="fa-solid fa-chevron-right"></i>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 네번째 슬라이드 끝 -->
	
	 <!-- 다섯번째 슬라이드 시작 -->
	 <c:if test="${directorfeat != null}">
		<div class="list_wrap">
			<div class="width">
				<h2 class="title"><b>${directorName}</b> 감독을 좋아하시나요? 이 작품은 어떠세요?</h2>
				<div class="swiper fifthSwiper">
					<div class="swiper-wrapper">
						<c:forEach items="${directorfeat}" var="d">
							<div class="swiper-slide list_movie">
								<a href="/main/detail?movieId=${d.id}"><img src="https://image.tmdb.org/t/p/w300/${d.poster_path}"></a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="swiper-btn2">
					<div class="swiper-prev5"><i class="fa-solid fa-chevron-left"></i>
					</div>
					<div class="swiper-next5"><i class="fa-solid fa-chevron-right"></i>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 다섯번째 슬라이드 끝 -->
	
	 <!-- 여섯번째 슬라이드 시작 -->
	 <c:if test="${actorfeat != null}">
		<div class="list_wrap">
			<div class="width">
				<h2 class="title"><b>${actorName}</b> 배우를 좋아하시나요? 이 작품은 어떠세요?</h2>
				<div class="swiper sixthSwiper">
					<div class="swiper-wrapper">
						<c:forEach items="${actorfeat}" var="a">
							<div class="swiper-slide list_movie">
								<a href="/main/detail?movieId=${a.id}"><img src="https://image.tmdb.org/t/p/w300/${a.poster_path}"></a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="swiper-btn2">
					<div class="swiper-prev6"><i class="fa-solid fa-chevron-left"></i>
					</div>
					<div class="swiper-next6"><i class="fa-solid fa-chevron-right"></i>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 여섯번째 슬라이드 끝 -->
	
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
	<script>
		var swiper = new Swiper(".fourthSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next4",
				prevEl : ".swiper-prev4",
			},
		});
	</script>
	<script>
		var swiper = new Swiper(".fifthSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next5",
				prevEl : ".swiper-prev5",
			},
		});
	</script>
	<script>
		var swiper = new Swiper(".sixthSwiper", {
			slidesPerView : 7,
			spaceBetween : 20,
			loop : true,
			navigation : {
				nextEl : ".swiper-next6",
				prevEl : ".swiper-prev6",
			},
		});
	</script>

</body>

</html>