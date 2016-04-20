package com.ktds.jmj.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.biz.ArticleBiz;
import com.ktds.jmj.vo.EmployeesVO;

@Controller
public class ArticleController {
	// Logger은 항상 class의 첫번째에 있어야 한다.
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private ArticleBiz articleBiz;
	
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}

	@RequestMapping("/list")
	public ModelAndView articleList (HttpSession session) {
		
		String nowDate = articleBiz.insertNewArticle();
		
		
		logger.trace("안녕하세요. 트레이스 입니다.");
		logger.debug("안녕하세요. 디버그 입니다.");
		logger.info("안녕하세요. 인포 입니다.");
		logger.warn("안녕하세요. 워닝 입니다.");
		logger.error("안녕하세요. 에러 입니다.");
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("article/list"); //어떤 페이지를 보여줄 것인가. jsp의 이름
		
		List<EmployeesVO> allEmployees = articleBiz.getAllEmployeeInfo();
		
		//request.setAttribute("Key", value);
		view.addObject("allEmployees", allEmployees);
		view.addObject("title", "제목");
		view.addObject("number", "번호");
		view.addObject("date", nowDate);
		view.addObject("author", "홍길동");
		
		return view;
	}
	
	@RequestMapping("/detail/{articleNumber}")
	public ModelAndView detail(@PathVariable int articleNumber) {
		ModelAndView view = new ModelAndView();
		view.setViewName("article/detail");
		view.addObject("articleNumber", articleNumber);
		
		return view;
	}
	
}




















