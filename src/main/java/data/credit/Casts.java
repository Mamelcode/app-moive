package data.credit;

//출연진 (감독, 배우)
public class Casts {

<<<<<<< HEAD
	String id; 					// 인물 id
	String name;   			   	// 이름
	String profile_path;   		 // 프로필 url 
	String known_for_department;   // 직업
	String order;				// 0부터~
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	public String getKnown_for_department() {
		return known_for_department;
	}
	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
=======
	String id; // 인물 id
	String name; // 이름
	String profile_path; // 프로필 url
	String known_for_department; // 직업
	int order; // 0부터~

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile_path() {
		return profile_path;
>>>>>>> 236272e83933d7c732e67496844344cf93653240
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	public String getKnown_for_department() {
		return known_for_department;
	}

	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}

	public int getOrder() {
		return order;
	}
<<<<<<< HEAD
	public void setOrder(String order) {
		this.order = order;
	}
	
	

		
=======

	public void setOrder(int order) {
		this.order = order;
	}

>>>>>>> 236272e83933d7c732e67496844344cf93653240
}
