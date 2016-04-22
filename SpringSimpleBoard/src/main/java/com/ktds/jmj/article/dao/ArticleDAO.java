package com.ktds.jmj.article.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;

public interface ArticleDAO {
	
	/**********************************************/
	/***** 			글쓰기 공통 메소드 	   	  *****/
	/**********************************************/
	
	public int nextArticleSeq();
	public String nowDate();
	
	public int insertNewArticle(ArticleVO articleVO);
	
	public int getTotalArticleCount();
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);
	public ArticleVO getOneArticle(String articleId);
	public int deleteArticle(String articleId);
	public int doModifyArticle(ArticleVO articleVO);
}