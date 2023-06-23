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
import org.joonzis.service.FreeService;
import org.joonzis.service.FreeServiceImpl;
import org.joonzis.vo.CVO;
import org.joonzis.vo.FVO;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/FreeController")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FreeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String resultCmd = "free_write";
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}


		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		int result ;
		
		CVO cvo2 = new CVO();
		FVO fvo = new FVO();
		String currentPage = request.getParameter("currentPage");
		FreeService service = new FreeServiceImpl();
		
		switch (resultCmd) {
		case "free_write":
			Paging pvo = new Paging();
			pvo.setTotalRecord(service.getAll_F());

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

			List<FVO> list2 = service.getTotalfree(map);
			request.setAttribute("list2", list2);

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
			path = "Free_write/free_write.jsp";
			break;
		case "free_write_view" :
			int f_idx = Integer.parseInt(request.getParameter("f_idx"));
			currentPage = request.getParameter("currentPage");

			fvo = service.selectById_free(f_idx);

			session.setAttribute("fvo", fvo);
			session.setAttribute("currentPage", currentPage);
			
			
			 List<CVO> cvo = service.cvoView(f_idx);
			 
			 request.setAttribute("cvo", cvo);
			 

			 open = (String)session.getAttribute("open");
			 if(open == null){  
			 session.setAttribute("open", "yes"); 
			 int hit = fvo.getFhit() + 1; 
			 fvo.setFhit(hit);
			  
			 service.getUpdateHit_free(fvo); 
			 }
			 
	    	
			isForward = true;
			path = "Free_write/free_write_view.jsp";
			break;
		case "free_insert_page" : 
			
			path = "Free_write/free_write_insert_page.jsp";
			break;
		case "free_insert" : 
			
			fvo.setMidx(Integer.parseInt(mr.getParameter("m_idx")));
			fvo.setFnickname(mr.getParameter("fnickname"));
			fvo.setFpw(mr.getParameter("fpw"));
			fvo.setFcontent(mr.getParameter("fcontent"));
			fvo.setFhit(0);
			
			 if(mr.getFile("filefree")!= null){
				 fvo.setFilefree(mr.getFilesystemName("filefree")); 
			 
			 }else{ 
				 fvo.setFilefree("");
			 }
			 
			result = service.getinsert(fvo);
			request.setAttribute("result", result);
			
			
			isForward = true;
			path = "FreeController?cmd=free_write&f_idx="+fvo.getF_idx();
			
			break;
		case "free_update_page" :
			
			isForward = true;
			path = "Free_write/free_write_update_page.jsp";
			break;
		case "update" :
			
			fvo.setFnickname(mr.getParameter("fnickname"));
			fvo.setFcontent(mr.getParameter("fcontent"));

			fvo.setF_idx(Integer.parseInt(mr.getParameter("f_idx")));
			fvo.setMidx(Integer.parseInt(mr.getParameter("m_idx")));
			
			File newfile = mr.getFile("filefree");		 // 새 첨부파일
			String oldfile = mr.getParameter("oldfile");
			// 기존 첨부파일
			if(newfile != null){						//새 첨부파일 o
				if(oldfile != null){					// 기존 첨부파일 o
					File removeFile1 = new File(realPath + "/" + oldfile);
					if(removeFile1.exists()){ 			// 기존 첨부파일 유무 확인
						removeFile1.delete();			// 기존 첨부파일 삭제
					}
				}
				fvo.setFilefree(newfile.getName());	 // 새 첨부파일 이름 저장
			}else{ 									//새 첨부파일 x
				if(oldfile != null){ // 기존 첨부파일 o
					fvo.setFilefree(oldfile);
				}else{ 								// 기존 첨부파일 x 새 첨부파일 x
					fvo.setFilefree("");
				}
			}
			
			
			result = service.updateByIdx_free(fvo);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "FreeController?cmd=free_write_view&f_idx="+fvo.getF_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "free_remove" : 
			fvo = (FVO)session.getAttribute("fvo"); 
	    	int f_idx2 = fvo.getF_idx();
	    
	    	String filename = fvo.getFilefree();
	    	
	    	File removeFile = new File(realPath + "/" + filename);
	    	
	    	if(removeFile.exists()){ // 기존 첨부파일 유무확인
	    		removeFile.delete(); //첨부파일 삭제
	    	}
	    	result = service.deleteByIdx_free(f_idx2);
	    	request.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "FreeController?cmd=free_write";
			break;
		case "insert_com" :
	    	
	    	cvo2.setWriter(request.getParameter("writer"));
	    	cvo2.setPw(request.getParameter("pw"));
	    	cvo2.setContent(request.getParameter("content"));
	    	cvo2.setF_idx(Integer.parseInt(request.getParameter("f_idx")));
	    	
	    	result = service.cinsertComment(cvo2);
	    	
	    	session.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "FreeController?cmd=free_write_view&f_idx="+cvo2.getF_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "remove_comment" :
			
			cvo2.setC_idx(Integer.parseInt(request.getParameter("c_idx")));
			cvo2.setF_idx(Integer.parseInt(request.getParameter("f_idx")));
			
	    	
			int c_idx = cvo2.getC_idx();
			
			result = service.deleteByCom_free(c_idx);
	    	session.setAttribute("result", result);
	    	
	    	isForward = true;
	    	
			path = "FreeController?cmd=free_write_view&f_idx="+cvo2.getF_idx()+"&currentPage="+session.getAttribute("currentPage");
			
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
