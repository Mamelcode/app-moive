package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 글작성 완료를 누르면 게시글 정보를 받아 처리할 컨트롤러
 */

@WebServlet("/main/post-task")
public class PostTaskController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/main/postlist.jsp").forward(req, resp);
	}
}
