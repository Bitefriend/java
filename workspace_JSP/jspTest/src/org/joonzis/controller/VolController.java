package org.joonzis.controller;

import java.io.File;
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

import org.joonzis.model.Paging;


import org.joonzis.service.VolService;
import org.joonzis.service.VolServiceImpl;
import org.joonzis.vo.FVO;
import org.joonzis.vo.VVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/VolController")
public class VolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VolController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
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
		String resultCmd = "volunteer_main";
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}


		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		int result ;

		VVO vvo = new VVO();
		String currentPage = request.getParameter("currentPage");
		VolService service = new VolServiceImpl();
		
		switch (resultCmd) {
		case "volunteer_main":
			Paging pvo = new Paging();
			pvo.setTotalRecord(service.getAll_V());

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

			List<VVO> list3 = service.getTotalfree(map);
			request.setAttribute("list3", list3);

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
			path = "volunteer/volunteer_main.jsp";
			break;
		case "vol_write_view" :
			
			int v_idx = Integer.parseInt(request.getParameter("v_idx"));
			currentPage = request.getParameter("currentPage");

			vvo = service.selectById_vol(v_idx);

			session.setAttribute("vvo", vvo);
			session.setAttribute("currentPage", currentPage);

			 open = (String)session.getAttribute("open");
			 if(open == null){  
			 session.setAttribute("open", "yes"); 
			 int hit = vvo.getHit() + 1; 
			 vvo.setHit(hit);
			  
			 service.getUpdateHit_vol(vvo); 
			 }
			 
	    	
			isForward = true;
			path = "volunteer/volunteer_view.jsp";
			break;
			
		case "vol_insert_page" : 
			path = "volunteer/volunteer_insert_page.jsp";
			break;
			
		case "vol_insert" : 
			
			vvo.setVtitle1(mr.getParameter("vtitle1"));
			vvo.setContent1(mr.getParameter("content1"));
			vvo.setVtitle2(mr.getParameter("vtitle2"));
			vvo.setContent2(mr.getParameter("content2"));
			vvo.setVtitle3(mr.getParameter("vtitle3"));
			vvo.setContent3(mr.getParameter("content3"));
			vvo.setTip(mr.getParameter("tip"));
			vvo.setHit(0);
			
			 if(mr.getFile("filefree")!= null){
				 vvo.setFilefree(mr.getFilesystemName("filefree")); 
			 
			 }else{ 
				 vvo.setFilefree("");
			 }
			 
			result = service.getinsert_vol(vvo);
			request.setAttribute("result", result);
			
			
			isForward = true;
			path = "VolController?cmd=volunteer_main&v_idx="+vvo.getV_idx();
			
			break;
		case "vol_update_page" : 
			isForward = true ;
			path = "volunteer/volunteer_update_page.jsp";
			
			break;
		case "vol_update" :
			
			vvo.setVtitle1(mr.getParameter("vtitle1"));
			vvo.setContent1(mr.getParameter("content1"));
			vvo.setVtitle2(mr.getParameter("vtitle2"));
			vvo.setContent2(mr.getParameter("content2"));
			vvo.setVtitle3(mr.getParameter("vtitle3"));
			vvo.setContent3(mr.getParameter("content3"));
			vvo.setTip(mr.getParameter("tip"));
			vvo.setV_idx(Integer.parseInt(mr.getParameter("v_idx")));
			
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
				vvo.setFilefree(newfile.getName());	 // 새 첨부파일 이름 저장
			}else{ 									//새 첨부파일 x
				if(oldfile != null){ // 기존 첨부파일 o
					vvo.setFilefree(oldfile);
				}else{ 								// 기존 첨부파일 x 새 첨부파일 x
					vvo.setFilefree("");
				}
			}
			
			
			result = service.updateByIdx_vol(vvo);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "VolController?cmd=vol_write_view&v_idx="+vvo.getV_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "vol_remove" : 
			vvo = (VVO)session.getAttribute("vvo"); 
	    	int v_idx2 = vvo.getV_idx();
	    
	    	String filename = vvo.getFilefree();
	    	
	    	File removeFile = new File(realPath + "/" + filename);
	    	
	    	if(removeFile.exists()){ // 기존 첨부파일 유무확인
	    		removeFile.delete(); //첨부파일 삭제
	    	}
	    	result = service.deleteByIdx_vol(v_idx2);
	    	request.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "VolController?cmd=volunteer_main";
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
