package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.HouseDao;
import pojo.House;
import utils.MyBatisUtils;

public class HouseService {
	
	private SqlSession session;
	private HouseDao sDao;
		
	private void into() {
		session=MyBatisUtils.getSession();
		sDao=session.getMapper(HouseDao.class);
	}
	
	//查询
	public List<House> select(House house){
		into();
		return sDao.select(house);
	}
	
	
	//查总条目数
		public int selectCount(House house) {
			into();
			return sDao.selectCount(house);
		}
	
	
	//根据房屋Id查房子详细信息
	public House selectId(int id) {
		into();
		return sDao.selectId(id);
	}
	
	//根据用户id 查
	public List<House> selectUserid(House house){
		into();
		return sDao.selectUserid(house);
	}
	public int selectUserIdCount(int id) {
		into();
		return sDao.selectUserIdCount(id);
	}
	
	
	//删除
		public boolean delete(int id) {
			into();
			int i = sDao.delete(id);
			session.commit();
			return i>0;
		}
		//添加
		public boolean insert(House house) {
			into();
			int i = sDao.insert(house);
			session.commit();
			return i>0;
		}
		//修改
		public boolean update(House house) {
			into();
			int i = sDao.update(house);
			session.commit();
			return i>0;
		}
	
	

}
