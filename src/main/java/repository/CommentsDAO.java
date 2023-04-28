package repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import data.Comment;
import data.Post;

public class CommentsDAO extends DAO {
	
	// DB에 영화 한줄평을 등록하는 메서드
	public static int createComment(String commentId, String movieId, String id, String name, String comments) {
		SqlSession session = factory.openSession(true);
		Map<String, Object> map = new HashMap<>();
		map.put("commentId", commentId);
		map.put("movieId", movieId);
		map.put("id", id);
		map.put("comments", comments);
		map.put("name", name);
		try {
			return session.insert("comment.create", map);
		} finally {
			session.close();
		}
	}
	
	// DB에서 a ~ b 번의 영화 한줄평 정보를 가저오는 메서드(영화 한줄평 리스트에 필요)
	public static List<Comment> findByCommentsAtoB (String movieId, int a, int b) {
		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("movieId", movieId);
		map.put("a", a);
		map.put("b", b);
		try {
			List<Comment> list = new LinkedList<>();
			list = session.selectList("comment.findByCommentsAtoB", map);
			return list;
		} finally {
			session.close();
		}
	}
	
	// DB에서 코멘트 삭제하는 메서드
	public static int deleteComment(String commentId) {
		SqlSession session = factory.openSession(true);
		try {
			return session.delete("comment.delete", commentId);
		} finally {
			session.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		/* 코멘트 삭제 테스트
		int result = deleteComment("e00d37e6");
		System.out.println("1이면 성공 그외는 실패 ==> "+ result);
		*/
		
		/* 코멘트 목록 가져오기 테스트
		List<Comment> list = findByCommentsAtoB("1q2w3e4r", 1, 2);
		list.forEach(c -> {
			System.out.println("한줄평 ==> "+ c.getComments());
			System.out.println("작성자 ==> "+ c.getName());
		});
		*/
		
		/* 코멘트 등록 테스트
		String commentId = UUID.randomUUID().toString().split("-")[0];
		int result = createComment(commentId, "1q2w3e4r", "master", "관리자", "정말 감동적이였어요!");
		System.out.println("1이면 성공 그외는 실패 ==> "+ result);
		*/
		
	}
}
