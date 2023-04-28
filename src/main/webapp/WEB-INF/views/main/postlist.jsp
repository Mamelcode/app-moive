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
	
  <div class="commu_wrap">
    <h2>커뮤니티</h2>
    <table>
				<thead class="table_head">
          <tr>
            <th>번호</th>
  					<th>제목</th>
  					<th>글쓴이</th>
  					<th>작성일</th>
  					<th>조회</th>
          </tr>
				</thead>
				<tbody>
						<tr>
							<td>1</td>
							<td><a href="">가나다라마바사</a></td>
							<td>무쥐개</td>
							<td>2023-04-26</td>
							<td>10</td>
						</tr>
				</tbody>
			</table>
      <div class="post_del">
        <a href="/main/write"><i class="fa-solid fa-square-pen"></i> 글쓰기</a>
      </div>

      <div class="page_nav">
        <a href="#" class="prev"><i class="fa-solid fa-angle-left"></i></a>
        <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#" class="next"><i class="fa-solid fa-angle-right"></i></a>
      </div>
  </div>

</body>

</html>