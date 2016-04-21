package com.ktds.jmj.article.biz;

import java.util.List;

import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;

public interface ArticleBiz {
	
	public boolean writeNewArticle(ArticleVO articleVO);

	public int getTotalArticleCount();

	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);

	public ArticleVO getOneArticle(String articleId);
	
	public boolean deleteArticle(String articleId);

	public boolean doModifyArticle(String articleId, ArticleVO articleVO);

}
