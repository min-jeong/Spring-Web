package com.ktds.jmj.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.jmj.dao.ArticleDAO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {
	// extends  다음 implements 순서중요
	//ArticleDAOImpl 위에 커서 놓고 Ctrl+1 단축키
	@Override
	public String getNowSystemDate() {
		return getSqlSession().selectOne("ArticleDAO.getNowSystemDate");
	}
	
	
}
