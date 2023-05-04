package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import repository.UsersDAO;
import service.UserService;

/*
 * 회원가입 정보를 넘겨받아 처리할 컨트롤러
 */

@WebServlet("/user/join-task")
public class JoinTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 한글 인코딩
		
	 	String id = req.getParameter("id"); // 아이디
		String pass = req.getParameter("pass"); // 비밀번호
		String name = req.getParameter("name"); // 닉네임
		
		// 텍스트 빈값 체크
		if(id.equals("") || pass.equals("") || name.equals("")) {
			resp.sendRedirect("/user/join?error=2");
			return;
		}
		
		System.out.println(id);
		System.out.println(pass);
		System.out.println(name);
		
		// 회원가입
		int result = UsersDAO.createUser(id, pass, name);
		System.out.println(result);
		if(result != 1) {
			resp.sendRedirect("/user/join?error=1");
			return;
		}
		
		// 유효성 검사
		 int validate = UserService.validate(id, pass, name);
		 if (validate == 3) {
			 resp.sendRedirect("/user/join?error=3");
				return;
		 }
		 
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
}

