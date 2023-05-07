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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
	<link href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro-v6@44659d9/css/all.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/resource/css/initial.css" />
	<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
	<link rel="stylesheet" href="/resource/css/style.css" >
</head>
<body class="all_wrap">

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
					<div class="search_box">
							<form action="/main/search">
								<input type="search" name="search" id="search" placeholder="Search..." list="slist">
								<span class="icon"><i class="fa fa-search"></i></span> 
								<ul class="search_list">
									<li id="ajax_list">
									</li>
								</ul>
							</form>
						</div> 
				</li>
			</ul>
			<ul class="topsearch">
				<li><span>${logonUser.name}님</span><a href="/user/logout" style="color: #C0FFFF;">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<!-- 탑 메뉴  끝 -->
	
	<!-- 검색 결과 -->
	<div class="result_wrap">
	<h2 class="title"><b>"${searchResult}"</b> <br>검색결과(${searchSize}건)</h2>
		<div class="width result_wrap_list">
		
			<c:forEach items="${searchList}" var="list">
				<c:set var="overview" value="${list.overview}"/>
				<div class="detail_top" onclick="location.href='/main/detail?movieId=${list.id}'">
					<!-- 포스터 부분 -->
					<div class="detail_poster">
						<img src="https://image.tmdb.org/t/p/w400/${list.poster_path}">
					</div>
					<!-- 포스터 부분 -->
					<!-- 영화정보 -->
					<div class="detail_text">
						<h2>${list.title}</h2>
						<h3>${list.release_date}</h3>
						<p>${fn:substring(overview,0,90)}...</p>
					</div>
					<!-- 영화정보 -->
				</div>
			</c:forEach>

		</div>
		
		<c:set var="currentPage" value="${empty param.page ? 1: param.page }"/>
      <div class="page_nav">

			<%-- prve 처리 --%>
			<c:choose>
				<c:when test="${existPrev }">
					<a href="/main/search?search=${param.search}&page=${start - 1}" class="prev"><i class="fa-solid fa-angle-left"></i></a>
				</c:when>
				<c:otherwise>
					<a class="prev"><i class="fa-solid fa-angle-left"></i></a>
				</c:otherwise>
			</c:choose>
			<%-- prve 처리 --%>

			<%-- 페이지 넘버 처리 --%>
			<c:forEach begin="${start}" end="${last}" var="idx">
				<c:choose>
					<c:when test="${idx eq currentPage}">
						<a class="active">${idx}</a>
					</c:when>
					<c:otherwise>
						<a href="/main/search?search=${param.search}&page=${idx}">${idx}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%-- 페이지 넘버 처리 --%>
			
			<%-- next 처리 --%>
			<c:choose>
				<c:when test="${existNext }">
					<a href="/main/search?search=${param.search}&page=${last + 1}" class="next"><i class="fa-solid fa-angle-right"></i></a>
				</c:when>
				<c:otherwise>
					<a class="next"><i class="fa-solid fa-angle-right"></i></a>
				</c:otherwise>
			</c:choose>
			<%-- next 처리 --%> 
      </div>
	</div>
	<!-- 검색 결과 -->

		<!-- 스크립트 부분 -->
	<script type="text/javascript">
		const input = document.getElementById("search");
	
		$('#search').keyup(function() {
			$('.search_list').addClass('active')
		});
		
		$('#search').keyup(function() {
			if(input.value.length == 0){
				$('.search_list').removeClass('active')
			}
		});
		
		$('.all_wrap').click(function() {
			$('.search_list').removeClass('active')
		});
	</script>
	
	<script type="text/javascript">
		const getValue = document.getElementById("search").onkeyup = function(evt) {
			let target = evt.target.value;
			
			const xhr = new XMLHttpRequest();
			xhr.open("get", "/search/ajax?search="+target, true);
			xhr.send();
			
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					const json = JSON.parse(xhr.responseText);
					const list = document.getElementById("ajax_list");
					list.innerHTML = "";
					let cnt = 0;
					for(let o of json) {
						list.innerHTML += "<ul class=\"search_result\">"+
						"<li class=\"result_img\">"+
						"<img src=\"https://image.tmdb.org/t/p/w300/"+ o.poster_path +"\">"+
						"</li>"+
						"<li><a href=\"/main/detail?movieId="+ o.id +" \" class=\"search_tit\">"+ o.title +"("+ o.release_date.substr(0, 4) +")</a>"+
						"<a class=\"search_stit\">"+ o.overview.substr(0, 30) +"...</a>"+
						"</li>"
						"</ul>";
						
						cnt++;
						if(cnt == 10) {
							break;
						}
					}
				}
			}
		};
	</script>
</body>
</html>