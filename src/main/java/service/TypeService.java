package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TypeDao;
import pojo.Type;
import utils.MyBatisUtils;

public class TypeService {

	private SqlSession session;
	private TypeDao sDao;
		
	private void into() {
		session=MyBatisUtils.getSession();
		sDao=session.getMapper(TypeDao.class);
	}
	
	//全部房型查询
	public List<Type> selectAll(){
		into();
		return sDao.selectAll();
	}
	
}
