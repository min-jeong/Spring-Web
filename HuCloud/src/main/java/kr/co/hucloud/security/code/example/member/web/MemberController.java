package kr.co.hucloud.security.code.example.member.web;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.hucloud.security.code.example.common.LoginStore;
import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.SendMessage;
import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;
import kr.co.hucloud.utilities.SHA256Util;

@Controller
public class MemberController {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value=("/member/login"), method=RequestMethod.POST )
	public void login(LoginVO loginVO, HttpSession session, HttpServletResponse response) {
		
		if ( memberService.isAccountLock(loginVO.getId()) ) { //true라면 잠긴 상태
			SendMessage.send(response, "OVER");
			return;
		}
		
		boolean isLoginSuccess = memberService.login(session, loginVO);
		// 로그인 횟수 제한 방어코드 작성
		if ( isLoginSuccess ) {
			/*
			 * 1. LOGIN_FAIL_COUNT를 0으로 초기화한다.
			 * 2. IS_ACCOUNT_LOCK 를 'N'으로 초기화한다.
			 * 3. LATEST_LOGIN_DATE를 현재시간으로 수정한다.
			 */
			memberService.loginSuccess(loginVO.getId());
			
			// Token 값 생성 및 등록 코드 작성
			// 이후 게시판 글 쓰기 페이지에서 Token 값 전달 받아 비교.
			String csrfToken = UUID.randomUUID().toString();
			session.setAttribute(Session.CSRF_TOKEN, csrfToken);
		
		}
		else {
			/*
			 * 1. LOGIN_FAIL_COUNT를 1 증가시킨다.
			 */
			memberService.plusLoginFailCount(loginVO.getId());
			/*
			 * 1. LOGIN_FAIL_COUNT가 5이상이라면 IS_ACCOUNT_LOCK를 'Y'로 수정한다.
			 */
			memberService.updateAccountLock(loginVO.getId());
			/*
			 * 1. IS_ACCOUNT_LOCK이 'Y'라면 브라우저에게 'OVER'라고 보낸다.
			 * 		OVER를 응답으로 받은 브라우저는 '로그인이 지속 실패하여 계정이 잠겼습니다. 운영자에게 문의하세요.'를 출력한다.
			 */
			boolean isLock = memberService.isAccountLock(loginVO.getId());
			if( isLock ){
				SendMessage.send(response, "OVER");
				return;
			}
			
		}
		
		SendMessage.send(response, isLoginSuccess ? "OK" : "NO");
	}
	
	@RequestMapping(value=("/member/logout"), method=RequestMethod.POST )
	public void logout(HttpSession session, HttpServletResponse response) {
		
		MemberVO member = (MemberVO) session.getAttribute(Session.MEMBER);
		LoginStore loginStore = LoginStore.getInstance();
		loginStore.logout(member.getId());
		
//		session.invalidate();
		SendMessage.send(response, "OK");
	}
	
	/*
	 * Ajax 리턴 방법 2가지 
	 * 1. void
	 * 2. @ResponseBody
	 */
	@RequestMapping("/member/registry" )
	public void registryMember(MemberRegistryVO memberVO, HttpServletResponse response) {
		try {
			// 회원가입시 비밀번호 체크하기
			/*
			 * 하나 이상의 알파벳을 포함해야 함
			 * 하나 이상의 숫자를 포함해야 함
			 * 하나 이상의 특수문자를 포함해야 함
			 * 최소 8글자 이상 입력해야 함
			 */
			
			boolean isVerifyPassword = verify(memberVO.getUserPassword());
			if( !isVerifyPassword ){ 
				//password가 취약하다면 addMember를 하지 않고 취약하다는 것을 사용자에게 알려준다.
				SendMessage.send(response, "-1");
				return;
			}
			
			// 회원가입시 비밀번호를 SHA-256 으로 SALT 이용해 암호화 하기
			String salt = SHA256Util.generateSalt();
			String newPassword = SHA256Util.getEncrypt(memberVO.getUserPassword(), salt);
			memberVO.setUserPassword(newPassword);
			memberVO.setSalt(salt);
			
			memberService.addMember(memberVO);
			SendMessage.send(response, "OK");
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			SendMessage.send(response, memberVO.getUserId() + "은(는) 이미 등록된 아이디 입니다.");
		} 
	}
	
	public boolean verify(String password) {
/*		String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int alphaCount = 0;
		for (int i = 0; i <password.length(); i++){
			if (alpha.indexOf( (password.charAt(i) + "")) != -1){
				alphaCount ++;
			}
		}
		
		String numbers = "0123456789";
		int numberCount = 0;
		for (int i = 0; i <password.length(); i++){
			if (numbers.indexOf( (password.charAt(i) + "")) != -1){
				numberCount ++;
			}
		}
		
		String symbols = "!@#$%^&*()_+-=[]{}/<>?,.;':`~";
		int symbolsCount = 0;
		for (int i = 0; i <password.length(); i++){
			if (symbols.indexOf( (password.charAt(i) + "")) != -1){
				symbolsCount ++;
			}
		}
		
		if ( alphaCount == 0 || symbolsCount == 0 || numberCount == 0 ){
			return false;
		}
		return true;*/
		
		String passwordPolicy = "((?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,})";
		Pattern pattern = Pattern.compile(passwordPolicy);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
}
