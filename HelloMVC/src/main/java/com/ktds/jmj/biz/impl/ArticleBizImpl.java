package com.ktds.jmj.biz.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.jmj.biz.ArticleBiz;

public class ArticleBizImpl implements ArticleBiz{

	private Logger logger = LoggerFactory.getLogger(ArticleBizImpl.class);
	
	@Override
	public void insertNewArticle() {
		logger.debug("insertNewArticle을 호출했습니다.");
	}
	
	
	
}
