package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PostsDAO;

/*
 * 글수정 완료를 누르면 수정정보를 넘겨받아 처리할 컨트롤러
 */

@WebServlet("/modify-task")
public class ModifyTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String postId = req.getParameter("postId");
		if (postId == null) {
			resp.sendRedirect("/main/postlist");
			return;
		}
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		
		System.out.println(postId);
		System.out.println(title);
		System.out.println(contents);
		
		// 게시글 수정 DB
		int postUpdate = PostsDAO.postUpdate(postId, title, contents);
		if (postUpdate != 1) {
			resp.sendRedirect("/main/detail?postId=" + postId);
			return;
		}

		resp.sendRedirect("/main/postlist");
		return;
	}
}
