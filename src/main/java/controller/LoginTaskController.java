package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 로그인 정보를 넘겨받아 처리할 컨트롤러
 */
@WebServlet("/user/login-task")
public class LoginTaskController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		/*
		//=========================================================
		SqlSessionFactory factory = (SqlSessionFactory)
				req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		User one = sqlSession.selectOne("users.findById", id);
		sqlSession.close();
		//=========================================================
	
		
		if(one.getPass().equals(pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("logon", true);
			session.setAttribute("logonUser", one);
			resp.sendRedirect("/index");
			return;
		}else {
			resp.sendRedirect("/user/Login.jsp?error=1");
			return;
		*/
		
	}
}
