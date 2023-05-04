package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PostsDAO;

/*
 * 글삭제를 누르면 처리해줄 컨트롤러
 */

@WebServlet("/post-delete")
public class PostDeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String postId = req.getParameter("postId");
		if (postId == null) {
			resp.sendRedirect("/main/postlist");
			return;
		}
		
		// 게시글 삭제 DB
		int postDelecte = PostsDAO.postDelecte(postId);
		if (postDelecte != 1) {
			resp.sendRedirect("/main/postdetail?postId=" + postId);
			return;
		}

		resp.sendRedirect("/main/postlist");
		return;
	}
}
