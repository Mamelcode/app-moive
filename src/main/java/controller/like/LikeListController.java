package controller.like;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.LikeActor;
import data.LikeDirector;
import data.LikeMovie;
import data.User;
import data.detail.MovieDetail;
import repository.LikesDAO;
import util.MovieAPI;

/*
 * 찜 리스트 정보를 받아서 화면으로 넘겨줄 컨트롤러(리스트 뷰)
 */

@WebServlet("/main/mylist")
public class LikeListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String movieId = req.getParameter("movieId");

		// 로그인 한 유저
		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");
		
		MovieDetail moviedetail = MovieAPI.getMoiveDetail(movieId);
		if (moviedetail == null) {
			resp.sendRedirect("/main/list");
			return;
		}

		List<LikeMovie> iikeMovie = LikesDAO.findByLikeMoives(logonUser.getId());

		List<LikeActor> likeActor = LikesDAO.findByLikeActors(logonUser.getId());

		List<LikeDirector> likeDirector = LikesDAO.findByLikeDirectors(logonUser.getId());
		
		//세팅
		req.setAttribute("iikeMovie", iikeMovie);
		req.setAttribute("likeActor", likeActor);
		req.setAttribute("likeDirector", likeDirector);
		
		req.getRequestDispatcher("/WEB-INF/views/main/mylist.jsp").forward(req, resp);
	}
}
