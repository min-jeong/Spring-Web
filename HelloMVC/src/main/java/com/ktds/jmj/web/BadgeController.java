package com.ktds.jmj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.jmj.vo.LoginVO;

@Controller
public class BadgeController {
	
	
	//pom.xml 에서 jackson-databind를 추가해줬기 때문에 json 타입으로 쓸 수 있다.
	//ResponseBody 가 반드시 필요하다.
	@RequestMapping("/newMember")
	@ResponseBody
	public LoginVO getNewMemberCountForAjax() {
		
		LoginVO loginVO = new LoginVO();
		
		loginVO.setId("ykim");
		loginVO.setMemberNumber(1);
		loginVO.setEnableAutoLogin(true);
		
		return loginVO;
	}
	
}
