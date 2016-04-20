package com.ktds.jmj.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.jmj.biz.ArticleBiz;
import com.ktds.jmj.dao.ArticleDAO;
import com.ktds.jmj.vo.EmployeesVO;

public class ArticleBizImpl implements ArticleBiz {
	
	private Logger logger = LoggerFactory.getLogger(ArticleBizImpl.class);
	
	private ArticleDAO articleDAO;
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	//블럭 씌우고 Ctrl+Alt+h : 검색 
	@Override
	public String insertNewArticle() {
		logger.debug("insertNewArticle을 호출했습니다~");
		String nowDate = articleDAO.getNowSystemDate();
		logger.info("현재시간은 {} 입니다." , nowDate);
		
		return nowDate;
	}

	@Override
	public List<EmployeesVO> getAllEmployeeInfo() {
		return articleDAO.getAllEmployeeInfo();
	}
	
	

}	
