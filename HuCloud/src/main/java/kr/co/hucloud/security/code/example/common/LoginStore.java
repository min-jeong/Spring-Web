package kr.co.hucloud.security.code.example.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public class LoginStore {
//	private static LoginStore loginStore = new LoginStore();
//	private static volatile LoginStore loginStore = new LoginStore();
	private static volatile LoginStore loginStore;
	private List<String> loginSessionIdList;
	private Map<String, HttpSession> loginSessions;
	
	private LoginStore() { //private 로 하면 생성자를 호출할 수 없다.
		loginSessions = new HashMap<String, HttpSession>();
		loginSessionIdList = new ArrayList<String>();
	}
	
	// synchronized 동기화
	public static synchronized LoginStore getInstance() { // LoginStore 내부에서 생성자를 만든다.
		// static : (메모리를 따로 가져간다.) instance를 만들지 않아도 사용할 수 있다. 
//		LoginStore loginStore = new LoginStore();
		
		if (loginStore == null) {
			loginStore = new LoginStore();
		}
		return loginStore;
	}
	
	public void add( String memberId, HttpSession session ) {
		loginSessions.put(memberId, session);
		loginSessionIdList.add(memberId);
	}
	
	public List<MemberVO> getAllLoginMembers() {
		  List<MemberVO> loginMembers = new ArrayList<MemberVO>();
		  for(String memberId : loginSessionIdList) {
		   loginMembers.add( (MemberVO) (get(memberId).getAttribute(Session.MEMBER)) );
		  }
		  return loginMembers;
	}


	public HttpSession get( String memberId ) {
		return loginSessions.get(memberId);
	}
	
	public void logout( String memberId ) {
		if ( loginSessions.containsKey(memberId) ) {
			try{
				loginSessions.get(memberId).invalidate(); // logout 시키기
			}
			catch(RuntimeException  re){}
		
			loginSessions.remove(memberId);
		}
	}
	
}
