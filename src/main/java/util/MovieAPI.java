package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import data.credit.Casts;
import data.detail.MovieDetail;
import data.grade.Result;
import data.grade.Results;
import data.popular.PoResult;
import data.show.ShowResult;

public class MovieAPI {
	
	// 영화를 평점순으로 뽑아오는 메서드
	public static Results getGradeList(String page) {
		try {
			String target = "https://api.themoviedb.org/3/movie/top_rated";
			
			Map<String, String> params = new LinkedHashMap<>();
			params.put("api_key", "8069e75d4de0c85b5ade5fc677a893a5");
			params.put("language", "ko-KR");
			params.put("page", page);
			String queryString = QueryStringBuilder.build(params);
			
			System.out.println(target + "?" + queryString);
			
			URI uri = new URI(target+ "?" +queryString);
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp =  client.send(req, BodyHandlers.ofString());
			
			Gson gson = new Gson();
			System.out.println(resp.body());
			
			Results result = gson.fromJson(resp.body(), Results.class);
			
			System.out.println(result.getResults()[0].getId());
			System.out.println(result.getResults()[0].getOverview());
			System.out.println(result.getResults()[0].getPoster_path());
			System.out.println(result.getResults()[0].getTitle());
			
			
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	// 영화를 인기순으로 뽑아오는 메서드
	public static List<PoResult> getPopularList(String page) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 영화를 현재상영순으로 뽑아오는 메서드
	public static List<ShowResult> getShowList(String page) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 특정 영화의 디테일을 가져오는 메서드
	public static MovieDetail getMoiveDetail(String movieId) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 특정 영화의 크레딧을 가져오는 메서드
	public static List<Casts> getCreditList(String movieId) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		getGradeList("1");
	}
}
