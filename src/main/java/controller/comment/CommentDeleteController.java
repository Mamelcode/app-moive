package controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.CommentsDAO;

/*
 * 한줄평 작성 후 정보를 넘겨받아서 처리할 컨트롤러
 */

@WebServlet("/detail/comment-delete")
public class CommentDeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		// 한줄평 commentId(받아오기)
		String movieId = req.getParameter("movieId");
		String commentId = req.getParameter("commentId");
		String id = req.getParameter("id");
		if (commentId.equals("")) {
			resp.sendRedirect("/main/detail?movieId=" + movieId + "&error=1");
			return;
		}

		System.out.println(id);
		
		// 로그인 유저 가져오기
		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");
		if (id.equals(logonUser.getId())) {

			// 한줄평 삭제
			int deleteComment = CommentsDAO.deleteComment(commentId);
			if (deleteComment != 1) {
				resp.sendRedirect("/main/detail?movieId=" + movieId + "&error=2");
				return;
			}

		}

		resp.sendRedirect("/main/detail?movieId=" + movieId);
	}
}
