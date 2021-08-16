package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.StreetDao;
import pojo.Street;
import utils.MyBatisUtils;

public class StreetService {
	private SqlSession session;
	private StreetDao sDao;
		
	private void into() {
		session=MyBatisUtils.getSession();
		sDao=session.getMapper(StreetDao.class);
	}
	
	//�������ز�ѯ�ֵ� 
	public List<Street> selectId(int id){
		into();
		return sDao.selectId(id);
	}

}
