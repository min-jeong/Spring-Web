package com.ktds.jmj.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.jmj.dao.ArticleDAO;
import com.ktds.jmj.vo.EmployeesVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {
	//extends  다음 implements 순서중요
	//ArticleDAOImpl 위에 커서 놓고 Ctrl+1 단축키
	
	//결과가 한개일 경우 selectOne
	@Override
	public String getNowSystemDate() {
		return getSqlSession().selectOne("ArticleDAO.getNowSystemDate");
	}
	
	// 결과가 여러개일 경우 selectList
	@Override
	public List<EmployeesVO> getAllEmployeeInfo() {
		
		// 첫번째 방법 lastName을 parameter로 보낸다.
		String lastName = "King";
		//return getSqlSession().selectList("ArticleDAO.getAllEmployeeInfo", lastName );
		
		
		// 두번째 방법 여러개를 보낼 경우 Map을 사용
		// <key, value> key는 무조건 String value는 무조건 Object (모든 타입을 대표한다)
		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("firstName", "Steven");
//		parameters.put("lastName", "King");
		//return getSqlSession().selectList("ArticleDAO.getAllEmployeeInfo", parameters );
		
		// 세번째 방법 VO를 이용하여 객체로 보내기
		EmployeesVO employee = new EmployeesVO();
//		employee.setFirstName("Steven");
//		employee.setLastName("King");
		
		
//---------------------------------------------------------------------------------------
		List<Integer> managerId = new ArrayList<Integer>();
		managerId.add(100);
		managerId.add(101);
		managerId.add(102);
		managerId.add(103);
		
		parameters.put("employee", employee);
		parameters.put("managerIds", managerId);
		
		// parameter는 무조건 하나만 쓸 수 있다. 여러개를 보낼 경우 Map으로 보낸다.
		return getSqlSession().selectList("ArticleDAO.getAllEmployeeInfo", parameters );
	}
	
	
}
