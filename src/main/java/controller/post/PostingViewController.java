package controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 글작성 버튼을 누르면 글 작성페이지로 넘겨줄 컨트롤러
 */

@WebServlet("/main/write")
public class PostingViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/main/postingview.jsp").forward(req, resp);
	}
}
