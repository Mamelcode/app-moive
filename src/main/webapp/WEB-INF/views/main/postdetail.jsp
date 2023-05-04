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
	
	<div class="commu_wrap">
    <div class="commu_detail">
      <h2>${post.title }</h2>
      <div class="commu_info">
        <h3><i class="fa-regular fa-user"></i> ${post.name }</h3>
        <ul>
          <li><i class="fa-regular fa-calendar"></i>${post.dates }</li>
          <li><i class="fa-regular fa-eye"></i>${post.views }</li>
        </ul>
      </div>
    </div>

    <div class="commu_text">
      <p>${post.contents }</p>
    </div>
    <div class="post_del">
    	<c:if test="${logonUser.id eq post.id }">
      		<a href="/modify?postId=${post.postId }"><i class="fa-solid fa-square-pen"></i> 수정</a>
      		<a href="/post-delete?postId=${post.postId }"><i class="fa-solid fa-square-xmark"></i> 삭제</a>
      	</c:if>
    </div>
  </div>

</body>
</html>