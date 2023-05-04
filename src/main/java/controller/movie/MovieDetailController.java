package controller.movie;

import java.io.IOException;
import java.util.ArrayList;
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
import data.preview.Presult;
import repository.CommentsDAO;
import repository.LikesDAO;
import util.MovieAPI;

/*
 * 영화 ID 를 이용해 영화 상세정보를 받아 상세보기페이지로 넘겨줄 컨트롤러
 */

@WebServlet("/main/detail")
public class MovieDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String movieId = req.getParameter("movieId");

//		System.out.println(movieId);

		// MovieAPI 에서 MovieDetail 가져오기 (moviedetail)
		MovieDetail moviedetail = MovieAPI.getMoiveDetail(movieId);

		if (moviedetail == null) {
			resp.sendRedirect("/main/list");
			return;
		}

		// MovieAPI 에서 Cast 가져오기 (Cast)
		Cast cast = MovieAPI.getCreditList(movieId);
		
		// 영화 예고편 가져오기
		Presult presult = MovieAPI.getPreview(movieId);
		// 티저영상 키값 (배열 0번째 [1번째]) 가져오기)
		String p = presult.getResults()[0].getKey();
		
		
		// 배우 5명만 세팅
		List<Casts> actorList = new ArrayList<>();
		for (Casts c : cast.getCast()) {
			if (c.getKnown_for_department().equals("Acting") && Integer.parseInt(c.getOrder()) < 5) {
				actorList.add(c);
			}
		}

		// 감독 1명 세팅
		List<Casts> directorList = new ArrayList<>();
		for (Casts d : cast.getCrew()) {
			if (d.getKnown_for_department().equals("Directing")) {
				directorList.add(d);
				break;
			}
		}

		// DB 에서 한줄평(comment) 정보 빼오기
		List<Comment> commentList = CommentsDAO.findByCommentsAtoB(movieId, 1, 10);

		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");
		
		//================================ 좋아요 체크 =====================================

		// DB 에서 배우 좋아요 체크
		List<LikeActor> likeActor = LikesDAO.findByLikeActors(logonUser.getId());
		for (Casts a : actorList) {
			for (LikeActor l : likeActor) {
				if (a.getId().equals(l.getActorId())) {
					a.setLike(true);
				}
			}
		}

		// DB 에서 영화 좋아요 체크
		List<LikeMovie> likeMovie = LikesDAO.findByLikeMoives(logonUser.getId());
		boolean movieLike = false;
		for (LikeMovie l : likeMovie) {
			if (movieId.equals(l.getMovieId())) {
				movieLike = true;
				break;
			}

		}
		// DB 에서 감독 좋아요 체크
		List<LikeDirector> likeDirector = LikesDAO.findByLikeDirectors(logonUser.getId());
		for (Casts d : directorList) {
			for (LikeDirector l : likeDirector) {
				if (d.getId().equals(l.getDirectorId())) {
					d.setLike(true);
				}
			}
		}
		
		//==============================================================================
		
		// 세팅(setAttribute)
		req.setAttribute("presult", p);
		req.setAttribute("commentList", commentList);
		req.setAttribute("director", directorList);
		req.setAttribute("moviedetail", moviedetail);
		req.setAttribute("actorList", actorList);
		req.setAttribute("movieLike", movieLike);
		

		req.getRequestDispatcher("/WEB-INF/views/main/detail.jsp").forward(req, resp);
	}
}
