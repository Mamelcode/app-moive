package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.UsersDAO;
import service.CookieService;

/*
 * 로그인 정보를 넘겨받아 처리할 컨트롤러
 */

@WebServlet("/user/login-task")
public class LoginTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 인코딩

		String id = req.getParameter("id"); // 아이디
		String pass = req.getParameter("pass"); // 비밀번호
		
		// 텍스트 빈값 체크
		if (id.equals("") || pass.equals("")) {
			resp.sendRedirect("/user/login?error=2");
			return;
		}
		
		// DB 에서 회원정보 가져오기
		User user = UsersDAO.findById(id);
		if(user == null ) {
			resp.sendRedirect("/user/login?error=1");
			return;
		}
		
		// 비밀번호(pass) 체크
		 if(!user.getPass().equals(pass)) {
			 resp.sendRedirect("/user/login?error=3");
			 return;
		 }
		 
		 // 유저 정보 유지 (Cookie 사용)
		Cookie[] cookies = req.getCookies();
		Cookie found = CookieService.findByName(cookies, "ID_SAVE");
		if (found != null) {
			req.setAttribute("idSave", found.getValue());
		}
		 
		 // 유저 정보 session 에 저장
		HttpSession session = req.getSession();
		session.setAttribute("logon", true);
		session.setAttribute("logonUser", user);
			
		// 쿠키 세팅
		Cookie c = new Cookie("ID_SAVE", id);
		c.setMaxAge(60 * 60 * 24 * 7);
		c.setPath("/");
		resp.addCookie(c);
			
		resp.sendRedirect("/main/list");
		
	}
}
