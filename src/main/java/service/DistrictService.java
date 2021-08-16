package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.DistrictDao;
import pojo.District;
import utils.MyBatisUtils;

public class DistrictService {
	private SqlSession session;
	private DistrictDao Dao;
		
	private void into() {
		session=MyBatisUtils.getSession();
		Dao=session.getMapper(DistrictDao.class);
	}
	
	//��ѯ����������Ϣ
	public List<District> selectAll(){
		into();
		return Dao.selectAll();
	}

}
