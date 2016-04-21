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
		System.out.println("?Œâ‘¦?“ƒæ¿¡ã…»?œ­ ï¿½ë–ï¿½ë»¾ï¿½ë¸¯æ¹²ï¿½ ï§ê³¸?Ÿ¾...");
		//æ¿¡ì’“? ‡ï¿½ì”¤ï§£ëŒ„ê²?
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("?Œâ‘¦?“ƒæ¿¡ã…»?œ­ ï¿½ë–ï¿½ë»¾ï¿½ë¸³ ï¿½ì” ï¿½ì‘");
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("?‡‰?š®?”ªï¿½ìŠ¦ï¿½ï¿½ï¿½ë¿‰å¯ƒï¿½ ï¿½ì“³ï¿½ë–Ÿï¿½ë¦ºæ¹²ï¿½ ï§ê³¸?Ÿ¾");
		
	}
	
}
