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
					<c:forEach items="${postList }" var="p"  varStatus="idx">
						<tr>
							<td>${idx.count}</td>
							<td><a href="/main/postdetail?postId=${p.postId }">${p.title }</a></td>
							<td>${p.name }</td>
							<td>${p.dates }</td>
							<td>${p.views }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
      <div class="post_del">
        <a href="/main/write"><i class="fa-solid fa-square-pen"></i> 글쓰기</a>
      </div>
	
	<!-- 페이징 처리 시작 -->
      <c:set var="currentPage" value="${empty param.page ? 1 : param.page }"/>
      <div class="page_nav">
      <%-- Prev 처리 --%>
      <c:choose>
      	<c:when test="">
      		<c:if test="${existPrev }">
        		<a href="/main/postlist?page=${start-1 } " class="prev"><i class="fa-solid fa-angle-left"></i></a>
      		</c:if>
      	</c:when>
      	<c:otherwise>
      	 		<a class="prev"><i class="fa-solid fa-angle-left"></i></a>
      	</c:otherwise>
      	</c:choose>
      <%-- Prev 처리끝 --%>
      <%-- 페이징 넘버 처리 --%>	
        <c:forEach var="idx" begin="${start }" end="${last }">
         	<c:choose>
        		<c:when test="${idx eq currentPage }">
        		       <a class="active">${idx }</a>
        		</c:when>
        		<c:otherwise>
        			<a href="/main/postlist?page=${idx }"> ${idx}</a>
        		</c:otherwise>
        	</c:choose>
		</c:forEach>
		<%-- 페이징 넘버 처리끝 --%>
		
		<%-- Next 처리 --%>
		<c:choose>
			<c:when test="${existNext }">
				<a href="/main/postlist?page=${last+1 }" class="next"><i class="fa-solid fa-angle-right"></i></a>
			</c:when>
			<c:otherwise>
				<a class="next"><i class="fa-solid fa-angle-right"></i></a>
			</c:otherwise>
        </c:choose>
      </div>
      <%-- Next 처리끝 --%>
  </div>

</body>

</html>