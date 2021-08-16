package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * @author 郭平源
 *
 */
public class MyBatisUtils {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> threadLocal= new ThreadLocal<SqlSession>();	
	
	static {		
		try {
			String resoString="mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resoString);
			factory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	/**
	 * 在同一线程获得的是同一个sqlSession
	 * @return
	 */
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if(session == null) {
			session = factory.openSession();
			threadLocal.set(session);
		}
		System.out.println("MyBatisUtils:"+session);
		return session;
	}
	
	//关闭
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		if(session != null) {
			session.close();
			threadLocal.set(null);
		}
	}

}
