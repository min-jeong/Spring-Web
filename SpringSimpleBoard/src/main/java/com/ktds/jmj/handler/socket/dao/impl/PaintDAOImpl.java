package com.ktds.jmj.handler.socket.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.jmj.handler.socket.dao.PaintDAO;

public class PaintDAOImpl extends SqlSessionDaoSupport implements PaintDAO {

	@Override
	public String getAnswer() {
		return getSqlSession().selectOne("PaintDAO.getAnswer");
	}

	@Override
	public void insertAnswer(String answer) {
		getSqlSession().insert("PaintDAO.insertAnswer",answer);
	}

	@Override
	public void deleteAnswer() {
		getSqlSession().delete("PaintDAO.deleteAnswer");
	}

}
