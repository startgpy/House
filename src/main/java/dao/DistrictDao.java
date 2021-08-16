package dao;

import java.util.List;

import pojo.District;



public interface DistrictDao {
	
	//查询所有区县信息
	public List<District> selectAll();

}
