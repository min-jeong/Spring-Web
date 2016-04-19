package com.ktds.pingpong.team.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.history.biz.OperationHistoryBiz;
import com.ktds.pingpong.history.vo.ActionCode;
import com.ktds.pingpong.history.vo.BuildDescription;
import com.ktds.pingpong.history.vo.Description;
import com.ktds.pingpong.history.vo.OperationHistoryVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamListVO;
import com.ktds.pingpong.team.vo.TeamVO;
import java.util.Collections;

/**
 * Servlet implementation class addNewMemberServlet
 */
public class addNewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	private OperationHistoryBiz historyBiz; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewMemberServlet() {
        super();
        teamBiz = new TeamBiz();
        historyBiz = new OperationHistoryBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TeamVO team = (TeamVO) session.getAttribute("_TEAM_");
		TeamListVO teamList = new TeamListVO();
		OperationHistoryVO historyVO = new OperationHistoryVO();
		request.setCharacterEncoding("UTF-8");
		
		String[] emailList = request.getParameterValues("email");
		List<String> emails = new ArrayList<String>();
		
		Collections.addAll(emails, emailList);
		
		for (int i=0; i < emails.size(); i++ ){
			if (emails.get(i).equals("") || emails.get(i) == null){
				emails.remove(i);
				i--;
			}
		}
		
		int teamId = team.getTeamId();
		String leaderEmail = team.getLeaderEmail();
		
		for ( String selectedEmail : emails ){
			
			teamList.setTeamId(teamId);
			teamList.setEmail(selectedEmail);
			if ( selectedEmail.equals(leaderEmail) ){
			teamList.setIsLeader("Y");
			}
			else {
				teamList.setIsLeader("N");
			}
			if ( teamId > 0 ) {
				teamBiz.insertNewTeamList(teamList);
			}
			
			historyVO.setIp(request.getRemoteHost());
			historyVO.setEmail(leaderEmail);
			historyVO.setUrl(request.getRequestURI());
			historyVO.setActionCode(ActionCode.TEAM);
			historyVO.setDescription(BuildDescription
					.get(Description.TEAM_CREATE , request.getParameter("teamName") , selectedEmail)
					);
			historyBiz.addHistory(historyVO);
		}
		response.sendRedirect("/goManageTeam");
	}
}
