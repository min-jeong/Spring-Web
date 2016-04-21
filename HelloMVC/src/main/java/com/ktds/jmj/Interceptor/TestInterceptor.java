package com.ktds.jmj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class TestInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println("?�⑦?��濡ㅻ?�� �떎�뻾�븯湲� 吏곸?��...");
		//濡쒓?���씤泥댄�?
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("?�⑦?��濡ㅻ?�� �떎�뻾�븳 �씠�썑");
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("?��?��?���슦���뿉寃� �쓳�떟�릺湲� 吏곸?��");
		
	}
	
}
