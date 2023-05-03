package controller.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		System.out.println("키워드 ==> "+ search);
		
		data.movielist.Results searchList = MovieAPI.getMovieSearchList(search);
		
		Gson gson = new Gson();
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(gson.toJson(searchList.getResults()));
		
	}
	
	public static void main(String[] args) {
		
		String date = "2014-07-20";
		
		System.out.println(date.substring(0, 4));
	}
}
