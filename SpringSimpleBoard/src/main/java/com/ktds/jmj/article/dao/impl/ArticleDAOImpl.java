package com.ktds.jmj.article.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.jmj.article.dao.ArticleDAO;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO {

	@Override
	public int insertNewArticle(ArticleVO articleVO) {
		return getSqlSession().insert("ArticleDAO.insertNewArticle", articleVO);
	}

	@Override
	public int nextArticleSeq() {
		return getSqlSession().selectOne("ArticleDAO.nextArticleSeq");
	}

	@Override
	public String nowDate() {
		return getSqlSession().selectOne("ArticleDAO.nowDate");
	}

	@Override
	public int getTotalArticleCount() {
		return getSqlSession().selectOne("ArticleDAO.getTotalArticleCount");
	}

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return getSqlSession().selectList("ArticleDAO.getAllArticle", searchVO);
	}

	@Override
	public ArticleVO getOneArticle(String articleId) {
		return getSqlSession().selectOne("ArticleDAO.getOneArticle", articleId);
	}

	@Override
	public int deleteArticle(String articleId) {
		return getSqlSession().delete("ArticleDAO.deleteArticle", articleId);
	}

	@Override
	public int doModifyArticle(String articleId, ArticleVO articleVO) {
		String newSubject = articleVO.getSubject();
		String newWriter = articleVO.getWriter();
		String newDescription = articleVO.getDescription();
		Map<String, Object> parameters = new HashMap<String,Object>();
		
		parameters.put("articleId", articleId);
		parameters.put("newSubject", newSubject);
		parameters.put("newWriter", newWriter);
		parameters.put("newDescription", newDescription);
		
		return getSqlSession().update("ArticleDAO.doModifyArticle", parameters);
	}

}
