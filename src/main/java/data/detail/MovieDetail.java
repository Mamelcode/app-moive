package data.detail;


//영화 상세내용
public class MovieDetail {

	String id;   // 영화아이디
	String overview;   // 줄거리
	String posterPath;  // 포스터 
	String tagline;    //  문구 (슬로건)
	String title;    // 제목
	MovieGenres genres;     // 영화 장르
	
	public String getId() {
		return id;
	}
	public String getOverview() {
		return overview;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public String getTagline() {
		return tagline;
	}
	public String getTitle() {
		return title;
	}
	
	
	
}
