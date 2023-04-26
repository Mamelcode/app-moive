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
 * 회원가입 정보를 넘겨받아 처리할 컨트롤러
 */
@WebServlet("/user/join-task")
public class JoinTaskController extends HttpServlet {

	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//======================================================
			SqlSessionFactory factory = (SqlSessionFactory)
					req.getServletContext().getAttribute("sqlSessionFactory");
			SqlSession sqlSession = factory.openSession();
			//======================================================
			
			String id = req.getParameter("id"); // 회원가입 ID
			
		}
}
