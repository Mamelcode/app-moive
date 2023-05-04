package controller.like;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.LikesDAO;
/*
 * 좋아요를 누르면 처리할 컨트롤러
 */

@WebServlet("/detail/mylist-movie")
public class MovieLikeTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		// ==================================================================

		String movieId = req.getParameter("movieId"); // 영화 id
		if (movieId == null) {
			resp.sendRedirect("/main/detail");
			return;
		}

		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");

		String posterURL = req.getParameter("posterURL");
		String movieName = req.getParameter("movieName");
		// ==================================================================

		// 영화 좋아요 정보 넘기기
		int createLikeMoive = LikesDAO.createLikeMoive(movieId, logonUser.getId(), posterURL, movieName);
		if (createLikeMoive != 1) {
			resp.sendRedirect("/main/mylist");
			return;
		}

		resp.sendRedirect("/main/detail?movieId=" + movieId);
		return;
	}
}
