package repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// DAO 데이터베이스나 파일 시스템 등과 같은 데이터 저장소에 대한 접근을 추상화
public class DAO {
	protected static SqlSessionFactory factory;
	static {
		try {
			factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis/config.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
