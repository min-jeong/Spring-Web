package com.hucloud.mvc.sample4.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * web.xml에 Controller 및 기타 자원들에 대한 설정이 존재함.
 * 
 * @author mcjang
 *
 */
@Controller
public class MemberController {
	
	@RequestMapping("/")
	public ModelAndView viewIndexPage() {
		return new ModelAndView("redirect:/member/list");
	}
	
	@RequestMapping("/member/list")
	public ModelAndView viewMemberListPage() {
		ModelAndView view = new ModelAndView("member/list");
		return view;
	}
	
	@RequestMapping(value="/member/detail/{userId}", method=RequestMethod.GET)
	public ModelAndView viewMemberDetailPageByUserId(@PathVariable String userId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("member/detail");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping(value="/member/update/{userId}", method=RequestMethod.POST)
	public ModelAndView viewMemberUpdatePageByUserId(@PathVariable String userId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("member/update");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping("/member/detail")
	public ModelAndView viewMemberDetailPageByUserId2(@RequestParam String userId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("member/detail");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping("/member/update")
	public ModelAndView viewMemberDetailPageByUserId2(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("member/update");
		
		String userId = request.getParameter("userId");
		
		view.addObject("userId", userId);
		return view;
	}
	
}