package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Post;
import data.User;
import repository.PostsDAO;

/*
 * 게시글 상세페이지 화면으로 넘겨줄 컨트롤러
 */

@WebServlet("/main/postdetail")
public class PostDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String postId = req.getParameter("postId");
		if (postId == null) {
			resp.sendRedirect("/main/postlist");
			return;
		}
		
		// 로그인 한 유저
		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser");
		
		
		// 글 상세보기 DB
		Post post = PostsDAO.findByPost(postId);
		if (post == null) {
			resp.sendRedirect("/main/postlist");
			return;
		}
		
		// 글 조회수 올리기 DB
		if (!logonUser.getId().equals(post.getId())) {
			int postViewUp = PostsDAO.postViewUp(postId);
		}
		
		req.setAttribute("post", post);

		req.getRequestDispatcher("/WEB-INF/views/main/postdetail.jsp").forward(req, resp);
	}
}
