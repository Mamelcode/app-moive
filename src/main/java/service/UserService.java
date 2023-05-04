package service;

public class UserService {
	public static int validate(String id, String pass, String name) {
		if (!id.matches("[a-z][a-z0-9]{3,}")) { // 소문자+숫자
			return 3;
		}
		if (pass.length() < 4) { // 4글자 이상
			return 3;
		}
		if (name.length() < 2) { // 2글자 이상
			return 3;
		}
		return 0;
	}
	
	
}
