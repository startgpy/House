package dao;

import org.apache.ibatis.annotations.Param;

import pojo.Users;

public interface UsersDao {
	    //��¼
		public Users selectLogin(@Param("name")String name,@Param("password")String pwassword);
		
		//�ж��û����Ƿ��ظ�
		public int selectName(@Param("name")String name);
		//ע��
		public int insertZc(Users users);
}
