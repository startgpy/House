package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.House;


public interface HouseDao {
	
	//查询
		public List<House> select(House house);
		//查总条目数
		public int selectCount(House house);
		//根据房屋id查房子详细信息
		public House selectId(@Param("id")int id);
		//根据用户id查
		public List<House> selectUserid(House house);
		public int selectUserIdCount(@Param("user_id") int id);
		//删除
		public int delete(@Param("hid")int hid);
		//添加
		public int insert(House house);
		//修改
		public int update(House house);
	

}
