package com.ktds.jmj.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.jmj.vo.LoginVO;

import kr.co.hucloud.utilities.excel.option.ReadOption;
import kr.co.hucloud.utilities.excel.read.ExcelRead;

/**
 * 서블릿을 대체할 클래스 
 * Controller라고 붙인다.
 */
@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	//RequestMethod.GET은 get으로만 들어올 수 있다는 정의이다.
	//브라우저의 요청이 get이니까 URL을 쳐서 들어올 수 있다.
	@RequestMapping(value="/home", method=RequestMethod.GET )
	public String index() { 
		Integer.parseInt("aaaa");
		
		return "mainPage";
	}
	
	//POST는 이제 URL로 못 쳐서 들어오고 폼으로만 들어올 수 있다는 의미이다.
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		
		if( session.getAttribute("_MEMBER_") != null ){
			//로그인을 했을 때의 처리
//			return "redirect:http://www.daum.net"; 절대 URL ( 다른 도메인에서의 절대 URL )
//			return "redirect:home"; 상대 URL
			
			// http://localhost:8080/home
			// Redirect는 response.sendRedirect와 같이 대량의 데이터를 보낼 수 없다.
			return "redirect:/home"; //같은 도메인 내에서의 절대 URL  
			
		}
		// WEB-INF/view/login/login.jsp
		return "login/login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
//	public String doLogin(HttpServletRequest request) {
//	public String doLogin(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("memberNumber") int memberNumber ) {
	public ModelAndView doLogin(@Valid LoginVO loginVO, Errors errors, HttpSession session, HttpServletResponse response) {		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
		
		//Valid 뒤에는 항상 Errors가 존재해야 한다. ( 반드시 Valid 뒤에 와야한다! )
		//errors는 자동으로 model에 들어간다. 이미 jsp에 보낼 데이터로 저장이 되어 있다.
		
		ModelAndView view = new ModelAndView();
		
		if( errors.hasErrors() ) { // 발생된 에러가 있으면
			view.setViewName("login/login"); //로그인 페이지로 이동
			return view;
		}
		// 발생된 에러가 없다면 home으로 이동
		view.setViewName("redirect:/home");
		
		
		MultipartFile uploadFile = loginVO.getUploadFile();
		if ( !uploadFile.isEmpty() ) {
//			String randomFileName = UUID.randomUUID().toString();
//			File tempFile = new File("D:\\" + randomFileName );
			File tempFile = new File("D:\\" + uploadFile.getOriginalFilename() );
			try {
				uploadFile.transferTo(tempFile);
				
				//TODO 엑셀파일 읽어와서 출력하기
				String filePath = tempFile.getAbsolutePath(); // 파일이 존재하는 절대경로
				if ( filePath.toUpperCase().endsWith(".XLS") || filePath.toUpperCase().endsWith(".XLSX") ) {
					ReadOption option = new ReadOption();
					option.setFilePath(filePath);
					option.setOutputColumns("A", "B", "C");
					option.setStartRow(1);
					
					List<Map<String, String>> excel = ExcelRead.read(option);
					
					String content = "";
					for ( Map<String,String> map :excel ) {
						content= "";
						content += map.get("A");
						content += "\t";
						content += map.get("B");
						content += "\t";
						content += map.get("C");
						logger.info(content);
					}
					
				}
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
		session.setAttribute("_MEMBER_", loginVO.getId());
		
		System.out.println("ID : " + loginVO.getId());
		System.out.println("PASSWORD : " + loginVO.getPassword());
		System.out.println("Member Number :" + loginVO.getMemberNumber());
		System.out.println("Enable Auto Login : " + loginVO.isEnableAutoLogin());
		
		for ( int i = 0; i < loginVO.getHobby().size(); i++){
			System.out.println("Hobby : " + loginVO.getHobby().get(i));
		}
		return view;
	}
}
