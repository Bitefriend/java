package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.service.ScService;
import org.joonzis.service.ScserviceImpl;
import org.joonzis.vo.SVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;




@WebServlet("/ScoreController")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScoreController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// ------------------------------------------------

		String cmd;
		cmd = request.getParameter("cmd");
		
		/*
		 * String realPath = request.getServletContext().getRealPath("/upload");
		 * MultipartRequest mr = null; if (cmd == null) { mr = new MultipartRequest(
		 * request, realPath, 1024 * 1024 * 10, "utf-8", new DefaultFileRenamePolicy()
		 * );
		 * 
		 * cmd = mr.getParameter("cmd"); }
		 */
		
		System.out.println(cmd);
		String resultCmd = "allList";
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}


		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		int result ;

		SVO svo = new SVO();
		ScService service = new ScserviceImpl();
		
		switch (resultCmd) {
		
		case "score_allList":
			
			Map<String, Integer> map = new HashMap<>();

			List<SVO> list = service.getscore(map);
			session.setAttribute("list", list);
			
			
			isForward = true;
			path = "score/score.jsp";
			break;
		case "insert_page" :
			path = "score/score_insert_page.jsp";
			break;
		case "insert" :
			svo.setAvg(Integer.parseInt(request.getParameter("avg")));
			svo.setMidx(Integer.parseInt(request.getParameter("midx")));
			svo.setMidx(Integer.parseInt(request.getParameter("m_idx")));
			/* svo.setSs_idx(Integer.parseInt(request.getParameter("ss_idx"))); */
			svo.setSub1(Integer.parseInt(request.getParameter("sub1")));
			svo.setSub2(Integer.parseInt(request.getParameter("sub2")));
			svo.setSub3(Integer.parseInt(request.getParameter("sub3")));
			svo.setSub4(Integer.parseInt(request.getParameter("sub4")));
			svo.setSubName(request.getParameter("subName"));
			System.out.println(svo.getMidx());
			
			result = service.getSinsert(svo);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "ScoreController?cmd=score_allLis";
			break;
		case "view" :
			int ss_idx = Integer.parseInt(request.getParameter("ss_idx"));
			svo = service.selectByIdx(ss_idx);
			
			session.setAttribute("svo", svo);
			
			isForward = true;
			path = "score/score_view.jsp";
			break;
		case "update_page" :
			
			
			path = "score/score_update_page.jsp";
			break;
		case "update" :	
			svo.setSs_idx(Integer.parseInt(request.getParameter("ss_idx")));
			svo.setSub1(Integer.parseInt(request.getParameter("sub1")));
			svo.setSub2(Integer.parseInt(request.getParameter("sub2")));
			svo.setSub3(Integer.parseInt(request.getParameter("sub3")));
			svo.setSub4(Integer.parseInt(request.getParameter("sub4")));
			svo.setAvg(Integer.parseInt(request.getParameter("avg")));
			svo.setSubName(request.getParameter("subName"));
			
			result = service.updateScore(svo);

			request.setAttribute("result", result);

			isForward = true;
			path = "ScoreController?cmd=view&ss_idx="+svo.getSs_idx()+"&currentPage=" + session.getAttribute("currentPage");
			/* path = "score/score.jsp"; */
			break;
		case "remove" :
			path = "score/score_remove_page.jsp";
			break;
		case "remove_page" : 
			SVO svo2 = (SVO)session.getAttribute("svo");
			int ss_idx2 = svo2.getSs_idx();
			System.out.println("===============" + ss_idx2);
			result = service.removeByIdx(ss_idx2);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "student/allList.jsp";
			break;
		}
		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
