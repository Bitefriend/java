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
import org.joonzis.service.BBSService;
import org.joonzis.service.BBSServiceImpl;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/BBSController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestController() {
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


		boolean isForward = false;
		String path = "";
		HttpSession session = request.getSession();
		int result ;
		CVO cvo2 = new CVO();
		BVO bvo = new BVO();
		String currentPage = request.getParameter("currentPage");
		BBSService service = new BBSServiceImpl();
		
		switch (resultCmd) {
		case "allList":
			Paging pvo = new Paging();
			pvo.setTotalRecord(service.getTotalRecord());

			pvo.setTotalPage();


			if (currentPage != null && !currentPage.isEmpty()) {
				pvo.setNowpage(Integer.parseInt(currentPage));
			}

			pvo.setBegin((pvo.getNowpage() - 1) * pvo.getRecordPerPage() + 1);
			pvo.setEnd(pvo.getBegin() + pvo.getRecordPerPage() - 1);

			int begin = pvo.getBegin();
			int end = pvo.getEnd();

			// 2. begin, end를 저장하는 Map 생성
			Map<String, Integer> map = new HashMap<>();
			map.put("begin", begin);
			map.put("end", end);

			/* BDao.getList() */ /* mapper에 있는 id "list_bbs" */
			List<BVO> list = service.getAll(map);
			request.setAttribute("list", list);

			// ------------- 페이징 처리를 위한 block 계산
			// 1. beginBlock, endBlock 계산
			pvo.setBeginBlock((pvo.getNowpage() - 1) / pvo.getPagePerBlock() * pvo.getPagePerBlock() + 1);
			pvo.setEndBlock(pvo.getBeginBlock() + pvo.getPagePerBlock() - 1);

			// 2. endBlock 조정하기
			if (pvo.getEndBlock() > pvo.getTotalPage()) {
				pvo.setEndBlock(pvo.getTotalPage());
			}
			// 3. 화면에서 페이징을 사용할 수 있도록 객체에 저장
			request.setAttribute("pvo", pvo);

			// 4. 게시물이 열린 경우 session에 저장되어야 되는데 ... 흠.. 추후 계속
			String open = (String) session.getAttribute("open");
			if (open != null) {
				session.removeAttribute("open");
			}
			isForward = true;
			path = "bbs/allList.jsp";
			break;

		case "view" :
			int b_idx = Integer.parseInt(request.getParameter("b_idx"));
			currentPage = request.getParameter("currentPage");

			bvo = service.selectById(b_idx);

			session.setAttribute("bvo", bvo);
			session.setAttribute("currentPage", currentPage);
			
			List<CVO> cvo = service.cvoView(b_idx);
			
	    	request.setAttribute("cvo", cvo);

			 open = ( String)session.getAttribute("open");
			 if(open == null){ 
			 //open이 null이면 해당 게시물을 처음 열었다는 의미 
			 session.setAttribute("open", "yes"); 
			 // value 값은 의미없음 
			 int hit = bvo.getHit() + 1; 
			 bvo.setHit(hit);
			  
			 service.getUpdateHit(bvo); 
			 }
			 
	    	
			isForward = true;
			path = "bbs/view.jsp";
			break;
		case "insert_page" : 
			path = "bbs/insert_page.jsp";
			break;
		case "insert" : 

			BVO vo = new BVO();
			vo.setWriter(mr.getParameter("writer"));
			vo.setTitle(mr.getParameter("title"));
			vo.setPw(mr.getParameter("pw"));
			vo.setContent(mr.getParameter("content"));
			vo.setHit(0);
			/* vo.setIp(request.getRemoteAddr()); // ipv 6  */
			String ip = Inet4Address.getLocalHost().getHostAddress(); // ipv 4
			vo.setIp(ip);
			
			/* 첨부파일 유무에 따라서 filename 값을 결정하자 */
			
			 if(mr.getFile("filename")!= null){
				 vo.setFilename(mr.getFilesystemName("filename")); 
			 
			 }else{ 
				 vo.setFilename("");
			 }
			 
			result = service.getinsert(vo);
			request.setAttribute("result", result);
			
			
			isForward = true;
			path = "index.jsp";
			
			break;
		case "remove" : 
			BVO bvo2 = (BVO)session.getAttribute("bvo"); 
	    	int b_idx2 = bvo2.getB_idx();
	    
	    	String filename = bvo.getFilename();
	    	
	    	File removeFile = new File(realPath + "/" + filename);
	    	
	    	if(removeFile.exists()){ // 기존 첨부파일 유무확인
	    		removeFile.delete(); //첨부파일 삭제
	    	}
	    	result = service.deleteByIdx(b_idx2);
	    	request.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "index.jsp";
			break;
			
		case "update_page" :
			path = "bbs/update_page.jsp";
			break;
		case "update" :
		
			bvo.setTitle(mr.getParameter("title"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
			bvo.setIp(Inet4Address.getLocalHost().getHostAddress());
			
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
			
			
			result = service.updateByIdx(bvo);
			request.setAttribute("result", result);
			
			isForward = true;
			path = "BBSController?cmd=view&b_idx="+bvo.getB_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "insert_com" :
	    	
	    	cvo2.setWriter(request.getParameter("writer"));
	    	cvo2.setPw(request.getParameter("pw"));
	    	cvo2.setContent(request.getParameter("content"));
	    	cvo2.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
	    	ip2 = Inet4Address.getLocalHost().getHostAddress(); // ipv 4
	    	cvo2.setIp(ip2);
	    	
	    	result = service.cinsertComment(cvo2);
	    	
	    	session.setAttribute("result", result);
	    	
	    	isForward = true;
			path = "BBSController?cmd=view&b_idx="+cvo2.getB_idx()+"&currentPage="+session.getAttribute("currentPage");
			
			break;
		case "remove_comment" :
			
			/* CVO cvoc = (CVO)session.getAttribute("cvo"); */
			
			cvo2.setC_idx(Integer.parseInt(request.getParameter("c_idx")));
			cvo2.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
			
	    	
			int c_idx = cvo2.getC_idx();
			
			result = service.deleteByCom(c_idx);
	    	session.setAttribute("result", result);
	    	
	    	isForward = true;
	    	
			path = "BBSController?cmd=view&b_idx="+cvo2.getB_idx()+"&currentPage="+session.getAttribute("currentPage");
			
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
