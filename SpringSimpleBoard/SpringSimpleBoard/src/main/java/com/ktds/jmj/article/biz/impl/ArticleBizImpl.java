package com.ktds.jmj.article.biz.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.dao.ArticleDAO;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {
	
	private ArticleDAO articleDAO;
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public boolean writeNewArticle(ArticleVO articleVO){
//		throw new NotImplementedException();
		
		int nextArticleId = articleDAO.nextArticleSeq();
		String nowDate = articleDAO.nowDate();
		
		/*
		 * ArticleID의 형식
		 * AR-20160421-000001 
		 */
		String articleId = "AR-" + nowDate + "-" + lpad(nextArticleId+"", 6, "0");
	
		articleVO.setArticleNumber(nextArticleId);
		articleVO.setArticleId(articleId);
		
		return articleDAO.insertNewArticle(articleVO) > 0;
	}
	
	/**
	 * 
	 * @param source 원본
	 * @param length 만들어져야 하는 길이
	 * @param defValue 채워질 글자
	 * @return
	 */
	private String lpad(String source, int length, String defValue) {
		
		int sourceLength = source.length(); //원본의 글자수
		int needLength = length - sourceLength; //필요한 글자수
		
		for ( int i = 0; i < needLength; i++ ) {
			source = defValue + source; //필요한 글자수 만큼 defValue가 앞에 붙을 것이다.
		}
		return source;
	}

	@Override
	public int getTotalArticleCount() {
		return articleDAO.getTotalArticleCount();
	}

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return articleDAO.getAllArticle(searchVO);
	}

	@Override
	public ArticleVO getOneArticle(String articleId) {
		return articleDAO.getOneArticle(articleId);
	}

	@Override
	public boolean deleteArticle(String articleId) {
		return articleDAO.deleteArticle(articleId) > 0;
	}

	@Override
	public boolean doModifyArticle(ArticleVO articleVO) {
		return articleDAO.doModifyArticle(articleVO) > 0;
	}

	
}
