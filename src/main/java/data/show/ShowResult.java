package data.show;


//상영중인 영화 리스트
public class ShowResult {
	
	String id; //영화아이디
	String overview;  // 줄거리
	String title;  // 제목
	String posterPath;  // 포스터
	String voteAverage; // 평점
	
	public String getId() {
		return id;
	}
	public String getOverview() {
		return overview;
	}
	public String getTitle() {
		return title;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public String getVoteAverage() {
		return voteAverage;
	}
	

}
