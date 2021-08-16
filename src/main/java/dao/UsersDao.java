package dao;

import org.apache.ibatis.annotations.Param;

import pojo.Users;

public interface UsersDao {
	    //登录
		public Users selectLogin(@Param("name")String name,@Param("password")String pwassword);
		
		//判断用户名是否重复
		public int selectName(@Param("name")String name);
		//注册
		public int insertZc(Users users);
}
