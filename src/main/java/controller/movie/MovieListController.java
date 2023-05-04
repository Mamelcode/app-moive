package controller.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.movielist.Results;
import util.MovieAPI;

/*
 * 영화 리스트 정보를 처리 후 담아서 메인화면으로 넘겨줄 컨트롤러
 */

@WebServlet("/main/list")
public class MovieListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// MovieAPI 에서 getMovieList 가져오기
		Results popular = MovieAPI.getMovieList("popular", "1"); // 인기순
		 Results topRated = MovieAPI.getMovieList("top_rated", "1"); // 평점순
		 Results nowPlaying = MovieAPI.getMovieList("now_playing", "1"); // 현재상영중
		
		 
		 // 정보들을 화면에 넘겨줄 값 세팅 (setAttribute)
		 req.setAttribute("topRated", topRated.getResults());
		 req.setAttribute("popular", popular.getResults());
		 req.setAttribute("nowPlaying", nowPlaying.getResults());
		 
		req.getRequestDispatcher("/WEB-INF/views/main/list.jsp").forward(req, resp);
	}
}

