package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Street;



public interface StreetDao {
	
	//�������ز�ѯ�ֵ�
	public List<Street> selectId(@Param("id") int id);

}
