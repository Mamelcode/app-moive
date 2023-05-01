package controller.movie;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Comment;
import data.LikeActor;
import data.LikeDirector;
import data.LikeMovie;
import data.User;
import data.credit.Cast;
import data.credit.Casts;
import data.detail.MovieDetail;
import repository.CommentsDAO;
import repository.LikesDAO;
import util.MovieAPI;

/*
 * 영화 ID 를 이용해 영화 상세정보를 받아 상세보기페이지로 넘겨줄 컨트롤러
 */

@WebServlet("/main/detail")
public class MovieDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인코딩
		req.setCharacterEncoding("utf-8");
		
		// 파라미터값 받기
		String movieId = req.getParameter("movieId");
		
		// 파라미터 빈값 체크
		if(movieId.equals("")) {
			resp.sendRedirect("/main/list");
			return;
		}
		
		// 유저정보를 가져온다.
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("logonUser");
		
		// 해당 영화 디테일 받아오기
		MovieDetail detail = MovieAPI.getMoiveDetail(movieId);
		// 해당 영화 크레딧 받아오기
		Cast cast = MovieAPI.getCreditList(movieId);
		
		// 한줄평 받아오기
		List<Comment> comList = CommentsDAO.findByCommentsAtoB(movieId, 1, 10);
		
		// 좋아요 여부 체크하기
		List<LikeMovie> likeList = LikesDAO.findByLikeMoives(user.getId());
		boolean check = false;
		if(likeList != null) {
			for(LikeMovie a : likeList) {
				if(a.getMovieId().equals(movieId)) {
					check = true;
					break;
				}
			}
		}
		
		
		// 크레딧 감독 1명 배우 5명 만 빼기
		int cnt = 0;
		// 배우 5명 빼기
		List<Casts> actors = new LinkedList<>();
		for(Casts c : cast.getCast()) {
			if(c.getKnown_for_department().equals("Acting") && Integer.parseInt(c.getOrder()) < 5) {
				actors.add(c);
				cnt ++;
			}
			if(cnt == 5) {
				break;
			}
		}
		
		// 유저의 배우 좋아요 리스트 뽑기
		List<LikeActor> likeActors = LikesDAO.findByLikeActors(user.getId());
		
		// 유저의 배우 좋아요 목록의 배우ID와 해당 디테일 배우들 ID를
		// 비교해서 같은ID가 있다면 Casts의 like를 true로 변경한다.
		for(Casts c : actors) {
			for(LikeActor l : likeActors) {
				if(c.getId().equals(l.getActorId())) {
					c.setLike(true);
				}
			}
		}
		
		// 감독 1명 빼기
		List<Casts> directors = new LinkedList<>();
		for(Casts c : cast.getCrew()) {
			if(c.getKnown_for_department().equals("Directing")) {
				directors.add(c);
				break;
			}
		}
		
		// 유저의 감독 좋아요 리스트 뽑기
		List<LikeDirector> likeDirector = LikesDAO.findByLikeDirectors(user.getId());
		
		// 유저의 감독 좋아요 목록의 감독ID와 해당 영화 디테일 감독 ID를
		// 비교해서 같은ID가 있다면 Casts의 like를 true로 변경한다.
		for(Casts c : directors) {
			for(LikeDirector l : likeDirector) {
				if(c.getId().equals(l.getDirectorId())) {
					c.setLike(true);
				}
			}
		}
		
		// 영화 디테일 값 및 배우와 감독값 / 한줄평 / 좋아요여부 세팅하기
		req.setAttribute("detail", detail);
		req.setAttribute("actors", actors);
		req.setAttribute("directors", directors);
		req.setAttribute("comments", comList);
		req.setAttribute("movielike", check);
		
		req.getRequestDispatcher("/WEB-INF/views/main/detail.jsp").forward(req, resp);
	}
}
