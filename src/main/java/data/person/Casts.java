package data.person;

public class Casts {
	String id;   // 영화 아이디
	String poster_path;   // 포스터
	String overview;  // 줄거리
	String title; // 제목
	String vote_average; // 평점
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVote_average() {
		return vote_average;
	}
	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}
}
