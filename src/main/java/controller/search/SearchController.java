package controller.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.youtube.Results;
import util.MovieAPI;

/*
 * 서치 정보를 넘겨줄 컨트롤러
 */

@WebServlet("/main/search")
public class SearchController extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String search = req.getParameter("search");
		System.out.println(search);
		
		
		data.movielist.Results searchList = MovieAPI.getMovieSearchList(search);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/main/search.jsp").forward(req, resp);
	}
}
