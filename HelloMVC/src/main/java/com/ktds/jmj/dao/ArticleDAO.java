package com.ktds.jmj.dao;

import java.util.List;

import com.ktds.jmj.vo.EmployeesVO;

public interface ArticleDAO {

	public String getNowSystemDate();
	
	public List<EmployeesVO> getAllEmployeeInfo();
}
