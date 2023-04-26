package data.credit;


//출연진 (감독, 배우)
public class Casts {

	String id; 					// 인물 id
	String name;   			   	// 이름
	String profilePath;   		 // 프로필 url 
	String knownForDepartment;   // 직업
	String order;				// 0부터~
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public String getKnownForDepartment() {
		return knownForDepartment;
	}
	public String getOrder() {
		return order;
	}
		
}
