package org.joonzis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.service.MemService;
import org.joonzis.service.MemserviceImpl;
import org.joonzis.vo.MVO;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int result;
		String cmd;
		cmd = request.getParameter("cmd");
		String resultCmd = "";
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}
		System.out.println(cmd);
		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		
		MemService service = new MemserviceImpl();
		MVO mvo = new MVO();
		
		switch (resultCmd) {
		case "loginPage" : 
			path = "member/loginPage.jsp";
			break;
		case "login" :
			mvo.setMid(request.getParameter("mid"));
			mvo.setMpw(request.getParameter("mpw"));
			//  해당 계정이 존재하는지 확인 (count 값 리턴)
	
			result = service.ckMember(mvo);
			session.setAttribute("result", result);
			if (result > 0) { // 해당 계정이 있을 때만 계정 가져와서 session에 저장
				session.setAttribute("member", service.getmidx(mvo));
			}

			isForward = true;
			path = "member/login.jsp";
			break;
		case "joinPage" : 
			
			isForward = true;
			path = "member/join.jsp";
			break;
		case "join" :
			mvo.setMid(request.getParameter("mid"));
			mvo.setMpw(request.getParameter("mpw"));
			mvo.setMname(request.getParameter("mname"));
			mvo.setMtel(request.getParameter("mtel"));
			mvo.setMage(Integer.parseInt(request.getParameter("mage")));
			
			System.out.println(mvo);
			result = service.getJoin(mvo);
			request.setAttribute("result", result);
			
			
			isForward = true;
			path = "member/joinPage.jsp";
			break;
		case "logout" :
			session.removeAttribute("member");
			path = "index.jsp";
			break;
		}
			
		
			
		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			response.sendRedirect(path);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
