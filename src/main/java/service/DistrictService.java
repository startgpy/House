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
	
	//查询所有县区信息
	public List<District> selectAll(){
		into();
		return Dao.selectAll();
	}

}
