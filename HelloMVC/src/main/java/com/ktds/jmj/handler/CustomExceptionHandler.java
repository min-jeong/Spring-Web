package com.ktds.jmj.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// com.ktds.jmj 아래에서 발생되는 모든 에러들을 확인한다.
// 에러가 발생하면 ExceptionHandler에 먼저 들어왔다가 간다.
@ControllerAdvice("com.ktds.jmj")
public class CustomExceptionHandler {
	
	// class<?extends throwable> []   throwable을 상속받고 있는 모든 클래스 중 어떤 것이 올지 모른다.
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeExceptionHandler(RuntimeException re, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("error/500");
		view.addObject("message", re.getMessage());
		String referer = request.getHeader("Referer"); // 링크를 클릭한 위치
		view.addObject("from", referer);
		view.addObject("content", "내가 보냄?");
		return view;
	}
}
