package org.joonzis.controller;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.model.Paging;
import org.joonzis.service.StudentService;
import org.joonzis.service.StudentServiceImpl;
import org.joonzis.vo.CVO;
import org.joonzis.vo.StudentVO;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// ------------------------------------------------

		String cmd;
		cmd = request.getParameter("cmd");
		String realPath = request.getServletContext().getRealPath("/upload"); 
		MultipartRequest mr = null;
		if (cmd == null) {
			mr = new MultipartRequest( 
					request, 
					realPath, 
					1024 * 1024 * 10, 
					"utf-8", 
					new DefaultFileRenamePolicy() 
					);
			
			cmd = mr.getParameter("cmd");
		}
		System.out.println(cmd);
		String resultCmd = "allList";
		String ip2;
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}

		CVO cvo2 = new CVO();
		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		int result ;
		int s_idx ;

		StudentVO bvo = new StudentVO();
		String currentPage = request.getParameter("currentPage");
		StudentService service2 = new StudentServiceImpl();
		
		switch (resultCmd) {
		case "allList":
			Paging pvo = new Paging();
			pvo.setTotalRecord(service2.getTotalRecord());

			pvo.setTotalPage();

			if (currentPage != null && !currentPage.isEmpty()) {
				pvo.setNowpage(Integer.parseInt(currentPage));
			}

			pvo.setBegin((pvo.getNowpage() - 1) * pvo.getRecordPerPage() + 1);
			pvo.setEnd(pvo.getBegin() + pvo.getRecordPerPage() - 1);

			int begin = pvo.getBegin();
			int end = pvo.getEnd();

			Map<String, Integer> map = new HashMap<>();
			map.put("begin", begin);
			map.put("end", end);

			List<StudentVO> list = service2.getAll(map);
			request.setAttribute("list", list);
			
			List<StudentVO> list2 = service2.gethit(map);
			/* s_idx = Integer.parseInt(request.getParameter("s_idx")); */
			System.out.println(list2);
			/* bvo = service2.gethit(s_idx); */
			session.setAttribute("list2", list2);

			pvo.setBeginBlock((pvo.getNowpage() - 1) / pvo.getPagePerBlock() * pvo.getPagePerBlock() + 1);
			pvo.setEndBlock(pvo.getBeginBlock() + pvo.getPagePerBlock() - 1);

			if (pvo.getEndBlock() > pvo.getTotalPage()) {
				pvo.setEndBlock(pvo.getTotalPage());
			}
			request.setAttribute("pvo", pvo);

			String open = (String) session.getAttribute("open");
			if (open != null) {
				session.removeAttribute("open");
			}
			isForward = true;
			path = "student/allList.jsp";
			break;
			
		case "view" :
			s_idx = Integer.parseInt(request.getParameter("s_idx"));
			currentPage = request.getParameter("currentPage");

			bvo = service2.selectById(s_idx);

			session.setAttribute("bvo", bvo);
			session.setAttribute("currentPage", currentPage);

			 open = (String)session.getAttribute("open");
			 if(open == null){  
			 session.setAttribute("open", "yes"); 
			 int hit = bvo.getHit() + 1; 
			 bvo.setHit(hit);
			  
			 service2.getUpdateHit(bvo); 
			 }
			 
	    	
			isForward = true;
			path = "student/allList_view.jsp";
			break;
		case "insert_page" : 
			path = "student/allList_insert_page.jsp";
			break;
		case "insert" : 

			StudentVO vo = new StudentVO();
			vo.setSname(mr.getParameter("sname"));
			vo.setStitle(mr.getParameter("stitle"));
			vo.setSpw(mr.getParameter("spw"));
			vo.setContent(mr.getParameter("content"));
			vo.setHit(0);
			
			 if(mr.getFile("filename")!= null){
				 vo.setFilename(mr.getFilesystemName("filename")); 
			 
			 }else{ 
				 vo.setFilename("");
			 }
			 
			result = service2.getinsert(vo);
			request.setAttribute("result", result);
			
			
			isForward = true;
			path = "index.jsp";
			
			break;
		case "update_page" :
			path = "student/allList_update_page.jsp";
			break;
		case "update" :
		
			bvo.setStitle(mr.getParameter("stitle"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setS_idx(Integer.parseInt(mr.getParameter("s_idx")));
			
			File newfile = mr.getFile("filename");		 // 새 첨부파일
			String oldfile = mr.getParameter("oldfile");
			// 기존 첨부파일
			if(newfile != null){						//새 첨부파일 o
				if(oldfile != null){					// 기존 첨부파일 o
					File removeFile1 = new File(realPath + "/" + oldfile);
					if(removeFile1.exists()){ 			// 기존 첨부파일 유무 확인
						removeFile1.delete();			// 기존 첨부파일 삭제
					}
				}
				bvo.setFilename(newfile.getName());	 // 새 첨부파일 이름 저장
			}else{ 									//새 첨부파일 x
				if(oldfile != null){ // 기존 첨부파일 o
					bvo.setFilename(oldfile);
				}else{ 								// 기존 첨부파일 x 새 첨부파일 x
					 bvo.setFilename("");
				}
			}
			
			
			result = service2.updateByIdx(bvo);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "MainController?cmd=view&s_idx="+bvo.getS_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "remove" : 
			StudentVO bvo2 = (StudentVO)session.getAttribute("bvo"); 
	    	int s_idx2 = bvo2.getS_idx();
	    
	    	String filename = bvo.getFilename();
	    	
	    	File removeFile = new File(realPath + "/" + filename);
	    	
	    	if(removeFile.exists()){ // 기존 첨부파일 유무확인
	    		removeFile.delete(); //첨부파일 삭제
	    	}
	    	result = service2.deleteByIdx(s_idx2);
	    	request.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "index.jsp";
			break;
		case "calendar" : 
			path = "calendar/calendar2.jsp";
			break;
			
		/*case "insert_com" :
	    	
	    	cvo2.setWriter(request.getParameter("writer"));
	    	cvo2.setPw(request.getParameter("pw"));
	    	cvo2.setContent(request.getParameter("content"));
	    	cvo2.setMidx(Integer.parseInt(request.getParameter("m_idx")));
	    	ip2 = Inet4Address.getLocalHost().getHostAddress(); // ipv 4
	    	cvo2.setIp(ip2);
	    	
	    	result = service2.cinsertComment(cvo2);
	    	
	    	session.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "MainController?cmd=view&midx="+cvo2.getMidx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;*/
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
