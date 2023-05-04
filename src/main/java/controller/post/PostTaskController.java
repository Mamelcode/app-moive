package controller.post;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.PostsDAO;

/*
 * 글작성 완료를 누르면 게시글 정보를 받아 처리할 컨트롤러
 */

@WebServlet("/main/post-task")
public class PostTaskController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8"); // 한글 인코딩
		
		// DB 에서 불러올 파라미터값  
		String title = req.getParameter("title"); // 제목
		String contents = req.getParameter("contents"); // 글내용
		String postId = UUID.randomUUID().toString().split("-")[0]; // postId
		
		if(title.equals("") || contents.equals("")) {
			resp.sendRedirect("/main/postlist.jsp");
			return;
		}
		HttpSession session = req.getSession();
		User logonUser = (User) session.getAttribute("logonUser"); // id(작성자id), name (닉네임)
		
		// DB 에 글 등록
		int createPost = PostsDAO.createPost(postId, logonUser.getId(), logonUser.getName(), title, contents);
		if(createPost != 1) {
			resp.sendRedirect("/main/postingview&error=1");
			return;
		}
		
		resp.sendRedirect("/main/postlist");
		return;
		
	}
}
