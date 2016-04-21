package com.ktds.jmj.article.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.article.service.ArticleService;
import com.ktds.jmj.article.vo.ArticleVO;

@Controller
public class ArticleController {
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	// 페이지를 보여주는 것이라고 알리기 위하여 앞에 view를 추가한다.
	@RequestMapping("/write")
	public ModelAndView viewWritePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/write");
		return view;
	}
	
	
	//Valid를 붙여 줘야 VO에 있는 NotEmpty가 작동한다.
	//Valid 뒤에는 Errors가 항상 있어야 한다.
	@RequestMapping("/doWriteAction")
	public ModelAndView doWriteAction(@Valid ArticleVO articleVO, Errors errors) {
		return articleService.writeNewArticle(articleVO, errors);
	}
}
