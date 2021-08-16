package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.House;


public interface HouseDao {
	
	//��ѯ
		public List<House> select(House house);
		//������Ŀ��
		public int selectCount(House house);
		//���ݷ���id�鷿����ϸ��Ϣ
		public House selectId(@Param("id")int id);
		//�����û�id��
		public List<House> selectUserid(House house);
		public int selectUserIdCount(@Param("user_id") int id);
		//ɾ��
		public int delete(@Param("hid")int hid);
		//���
		public int insert(House house);
		//�޸�
		public int update(House house);
	

}
