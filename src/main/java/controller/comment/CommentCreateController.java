package controller.comment;

import java.io.IOException;
import java.util.UUID;

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

@WebServlet("/detail/comment-create")
public class CommentCreateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		// comment
		String movieId = req.getParameter("movieId");
		String comments = req.getParameter("comments");
		if (comments.equals("")) {
			resp.sendRedirect("/main/detail?movieId=" + movieId + "&error=1");
			return;
		}
		
		// UUID => commentId 에 랜덤 코드 생성
		String commentId = UUID.randomUUID().toString().split("-")[0];

		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");

		// DB 에 한줄평(comment) 정보 넘기기
		int createComment = CommentsDAO.createComment(commentId, movieId, logonUser.getId(), logonUser.getName(),
				comments);
		if (createComment != 1) {
			resp.sendRedirect("/main/detail?movieId=" + movieId + "&error=2");
			return;
		}

		resp.sendRedirect("/main/detail?movieId=" + movieId);
	}
}
