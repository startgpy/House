package service;

import org.apache.ibatis.session.SqlSession;

import dao.UsersDao;
import pojo.Users;
import utils.MyBatisUtils;

public class UsersService {
	
	private SqlSession session;
	private UsersDao uDao;
		
	private void into() {
		session=MyBatisUtils.getSession();
		uDao=session.getMapper(UsersDao.class);
	}
	
	//��¼
	public Users login(String name,String pwd) {
		into();
		return uDao.selectLogin(name, pwd);
	}
	
	  //�ж��û����Ƿ��ظ�
		public boolean seName(String name) {
			into();
			return uDao.selectName(name)>0;
		}
		
		//ע��
		public boolean insertUser(Users users) {
			into();
			int i = uDao.insertZc(users);
			session.commit();
			return i>0;
		}

}
