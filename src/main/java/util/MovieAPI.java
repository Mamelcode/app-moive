package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import data.credit.Cast;
import data.credit.Casts;
import data.detail.MovieDetail;
import data.grade.Results;
import data.popular.PoResult;
import data.popular.PoResults;
import data.show.ShowResult;
import data.show.ShowResults;

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

			URI uri = new URI(target + "?" + queryString);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

			Gson gson = new Gson();
			System.out.println(resp.body());

			Results result = gson.fromJson(resp.body(), Results.class);

			System.out.println("result : " + result.getResults()[0].getId());
			System.out.println("result : " + result.getResults()[0].getOverview());
			System.out.println("result : " + result.getResults()[0].getPoster_path());
			System.out.println("result : " + result.getResults()[0].getTitle());

			return null;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	// 영화를 인기순으로 뽑아오는 메서드
	public static List<PoResult> getPopularList(String page) {
		try {
			String target = "https://api.themoviedb.org/3/movie/popular";

			Map<String, String> params = new LinkedHashMap<>();
			params.put("api_key", "8069e75d4de0c85b5ade5fc677a893a5");
			params.put("language", "ko-KR");
			params.put("page", page);
			String queryString = QueryStringBuilder.build(params);

			System.out.println(target + "?" + queryString);

			URI uri = new URI(target + "?" + queryString);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

			Gson gson = new Gson();
			System.out.println(resp.body());

			PoResults poResults = gson.fromJson(resp.body(), PoResults.class);

			System.out.println("poResult == > " + poResults.getResults()[0].getId());
			System.out.println("poResult == > " + poResults.getResults()[0].getOverview());
			System.out.println("poResult == > " + poResults.getResults()[0].getPoster_path());
			System.out.println("poResult == > " + poResults.getResults()[0].getTitle());

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 영화를 현재상영순으로 뽑아오는 메서드
	public static List<ShowResult> getShowList(String page) {
		try {
			String target = "https://api.themoviedb.org/3/movie/now_playing";

			Map<String, String> params = new LinkedHashMap<>();
			params.put("api_key", "8069e75d4de0c85b5ade5fc677a893a5");
			params.put("language", "ko-KR");
			params.put("region", "KR");
			params.put("page", page);
			String queryString = QueryStringBuilder.build(params);

			System.out.println(target + "?" + queryString);

			URI uri = new URI(target + "?" + queryString);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

			Gson gson = new Gson();
			System.out.println(resp.body());

			ShowResults showResults = gson.fromJson(resp.body(), ShowResults.class);

			System.out.println("showResults == > " + showResults.getResults()[0].getId());
			System.out.println("showResults == > " + showResults.getResults()[0].getOverview());
			System.out.println("showResults == > " + showResults.getResults()[0].getTitle());
			System.out.println("showResults == > " + showResults.getResults()[0].getPoster_path());
			System.out.println("showResults == > " + showResults.getResults()[0].getVote_average());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 특정 영화의 디테일을 가져오는 메서드
	public static MovieDetail getMoiveDetail(String movieId) {
		try {
			String target = "https://api.themoviedb.org/3/movie/" + movieId + "";

			Map<String, String> params = new LinkedHashMap<>();
			params.put("api_key", "8069e75d4de0c85b5ade5fc677a893a5");
			params.put("language", "ko-KR");

			String queryString = QueryStringBuilder.build(params);

			System.out.println(target + "?" + queryString);

			URI uri = new URI(target + "?" + queryString);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

			Gson gson = new Gson();
			System.out.println(resp.body());

			MovieDetail movieDetail = gson.fromJson(resp.body(), MovieDetail.class);

			System.out.println("movieDetail == > " + movieDetail.getId());
			System.out.println("movieDetail == > " + movieDetail.getOverview());
			System.out.println("movieDetail == > " + movieDetail.getPoster_path());
			System.out.println("movieDetail == > " + movieDetail.getTagline());
			System.out.println("movieDetail == > " + movieDetail.getTitle());
			System.out.println("movieDetail == > " + movieDetail.getGenres());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 특정 영화의 크레딧을 가져오는 메서드
	public static List<Casts> getCreditList(String movieId) {
		try {
			String target = "https://api.themoviedb.org/3/movie/" + movieId + "/credits";

			Map<String, String> params = new LinkedHashMap<>();
			params.put("api_key", "8069e75d4de0c85b5ade5fc677a893a5");
			params.put("language", "ko-KR");

			String queryString = QueryStringBuilder.build(params);

			System.out.println(target + "?" + queryString);

			URI uri = new URI(target + "?" + queryString);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(uri).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

			Gson gson = new Gson();
			System.out.println(resp.body());

			Cast casts = gson.fromJson(resp.body(), Cast.class);

			System.out.println("Casts == > " + casts.getCast()[0].getId());
			System.out.println("Casts == > " + casts.getCast()[0].getName());
			System.out.println("Casts == > " + casts.getCast()[0].getKnown_for_department());
			System.out.println("Casts == > " + casts.getCast()[0].getProfile_path());
			System.out.println("Casts == > " + casts.getCast()[0].getOrder());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		getCreditList("238");
	}
}
