package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Street;



public interface StreetDao {
	
	//根据区县查询街道
	public List<Street> selectId(@Param("id") int id);

}
