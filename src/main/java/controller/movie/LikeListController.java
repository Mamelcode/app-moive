package controller.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 찜 리스트 정보를 받아서 화면으로 넘겨줄 컨트롤러
 */

@WebServlet("/main/mylist")
public class LikeListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/main/mylist.jsp").forward(req, resp);
	}
}
