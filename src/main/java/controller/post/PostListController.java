package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 게시글 목록을 담아 커뮤니티 화면으로 넘겨줄 컨트롤러
 */

@WebServlet("/main/postlist")
public class PostListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/main/postlist.jsp").forward(req, resp);
	}
}
