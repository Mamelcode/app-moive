<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><span>000님</span><a href="">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<!-- 탑 메뉴  끝 -->

	  <div class="detail_wrap">
    <div class="width detail_top">
      <div class="detail_poster">
        <img src="https://image.tmdb.org/t/p/w400/f6dNinWX8rBM79JXKcShkfSh2oA.jpg">
        <div class="detail_star">
          <h4>한줄평</h4>
          <form class="" action="index.html" method="post">
            <input type="text" name="comment" value="">
            <button type="submit" name="button"><i class="fa-regular fa-paper-plane"></i> 작성</button>
          </form>
          <p><i class="fa-solid fa-message-smile"></i>감사합니다.</p>
          <p><i class="fa-solid fa-message-smile"></i>안녕하세요.</p>
          <p><i class="fa-solid fa-message-smile"></i>잘가세요!</p>
          <p><i class="fa-solid fa-message-smile"></i>잘봤어요!</p>
          <p><i class="fa-solid fa-message-smile"></i>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
          <p><i class="fa-solid fa-message-smile"></i>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
      </div>
      <div class="detail_text">
        <h2>다크나이트 <a href=""><i class="fa-solid fa-plus"></i></a> <a href="" class="active"><i class="fa-regular fa-check"></i></a></h2>
        <h3>부제목</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <div class="detail_direc">
          <h4>감독</h4>
          <img src="https://image.tmdb.org/t/p/w200/xuAIuYSmsUzKlUMBFGVZaWsY3DZ.jpg">
          <span>크리스토퍼 놀란</span>
        </div>
        <div class="detail_actor">
          <h4>배우</h4>
          <ul>
            <li><img src="https://image.tmdb.org/t/p/w300/qCpZn2e3dimwbryLnqxZuI88PTi.jpg">
            <span>크리스찬 베일</span></li>
            <li><img src="https://image.tmdb.org/t/p/w300/5Y9HnYYa9jF4NunY9lSgJGjSe8E.jpg">
            <span>크리스찬 베일</span></li>
            <li><img src="https://image.tmdb.org/t/p/w300/hZruclwEPCKw3e83rnFSIH5sRFZ.jpg">
            <span>크리스찬 베일</span></li>
            <li><img src="https://image.tmdb.org/t/p/w300/2v9FVVBUrrkW2m3QOcYkuhq9A6o.jpg">
            <span>크리스찬 베일</span></li>
            <li><img src="https://image.tmdb.org/t/p/w300/5EFQvRHlpP1Iaw2e6vjOaBny6DV.jpg">
            <span>크리스찬 베일</span></li>
          </ul>
        </div>
        <div class="de_youtube">
          <iframe width="980" height="550" src="https://www.youtube.com/embed/ty1XzpkAAQA" title="YouTube video player" frameborder="0" 
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </div>
      </div>
    </div>

  </div>


</body>
</html>