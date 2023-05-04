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
 * 좋아요 취소를 처리할 컨트롤러
 */

@WebServlet("/detail/director-unlike")
public class UnLikeDirectorTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 한글 인코딩
		// ==================================================================
		// 감독 좋아요 삭제
		String movieId = req.getParameter("movieId");
		String position = req.getParameter("position");
		String directorId = req.getParameter("directorId");
		if (directorId == null) {
			resp.sendRedirect("/main/detail");
			return;
		}
		
		System.out.println(movieId);
		System.out.println(position);
		System.out.println(directorId);
		
		// 유저 id
		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");
		// ==================================================================

		// 감독 좋아요 삭제
		int deleteLikeDirector = LikesDAO.deleteLikeDirector(directorId, logonUser.getId());
		if (deleteLikeDirector != 1) {
			resp.sendRedirect("/main/mylist");
			return;

		}
		if (position.equals("detail")) {
			resp.sendRedirect("/main/detail?movieId=" + movieId);
			return;
		} else if (position.equals("mylist")) {
			resp.sendRedirect("/main/mylist");
			return;
		}
	}
}
