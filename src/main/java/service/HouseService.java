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
	
	//��ѯ
	public List<House> select(House house){
		into();
		return sDao.select(house);
	}
	
	
	//������Ŀ��
		public int selectCount(House house) {
			into();
			return sDao.selectCount(house);
		}
	
	
	//���ݷ���Id�鷿����ϸ��Ϣ
	public House selectId(int id) {
		into();
		return sDao.selectId(id);
	}
	
	//�����û�id ��
	public List<House> selectUserid(House house){
		into();
		return sDao.selectUserid(house);
	}
	public int selectUserIdCount(int id) {
		into();
		return sDao.selectUserIdCount(id);
	}
	
	
	//ɾ��
		public boolean delete(int id) {
			into();
			int i = sDao.delete(id);
			session.commit();
			return i>0;
		}
		//���
		public boolean insert(House house) {
			into();
			int i = sDao.insert(house);
			session.commit();
			return i>0;
		}
		//�޸�
		public boolean update(House house) {
			into();
			int i = sDao.update(house);
			session.commit();
			return i>0;
		}
	
	

}
