package com.ktds.jmj.article.service;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.article.vo.ArticleVO;

public interface ArticleService {
	
	public ModelAndView writeNewArticle(ArticleVO articleVO, Errors errors);

	public ModelAndView getAllArticleList(int pageNo);

	public ArticleVO getOneArticle(String articleId);

	public ModelAndView deleteArticle(String articleId);

	public ModelAndView modifyArticle(String articleId);
	
}




