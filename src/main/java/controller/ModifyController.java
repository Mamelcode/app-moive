package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 * 글수정을 누르면 게시글 정보들을 담아 수정화면으로 넘겨줄 컨트롤러
 */
@WebServlet("/modify")
public class ModifyController extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.getRequestDispatcher("/WEB-INF/views/users/ModifyPost.jsp").forward(req, resp);
	}
}
