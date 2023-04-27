package data.detail;

//영화 상세내용
public class MovieDetail {

<<<<<<< HEAD
	String id;   // 영화아이디
	String overview;   // 줄거리
	String poster_path;  // 포스터 
	String tagline;    //  문구 (슬로건)
	String title;    // 제목
	MovieGenres genres;     // 영화 장르
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
=======
	String id; // 영화아이디
	String overview; // 줄거리
	String poster_path; // 포스터
	String tagline; // 문구 (슬로건)
	String title; // 제목
	MovieGenres[] genres; // 영화 장르

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
>>>>>>> 236272e83933d7c732e67496844344cf93653240
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getTagline() {
		return tagline;
	}
<<<<<<< HEAD
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MovieGenres getGenres() {
		return genres;
	}
	public void setGenres(MovieGenres genres) {
		this.genres = genres;
	}
	
	
	
	
=======

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieGenres[] getGenres() {
		return genres;
	}

	public void setGenres(MovieGenres[] genres) {
		this.genres = genres;
	}

>>>>>>> 236272e83933d7c732e67496844344cf93653240
}
