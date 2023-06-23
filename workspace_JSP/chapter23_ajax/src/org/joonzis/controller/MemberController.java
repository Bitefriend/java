package org.joonzis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.joonzis.dto.MemberDTO;
import org.joonzis.service.MemService;
import org.joonzis.service.MemserviceImpl;




@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		MemService service = new MemserviceImpl();
		List<MemberDTO> list = service.getMemberList();		
		PrintWriter out = response.getWriter(); // response가 다시 index.jsp로 리턴
		String result = "";
		StringBuffer sb = new StringBuffer();
		
		switch(cmd) {
		case"csv":
			for(MemberDTO dto : list) {
				sb.append(dto.getMidx() + ",");
				sb.append(dto.getMid() + ",");
				sb.append(dto.getMname() + ",");
				sb.append(dto.getMemail() + ",");
				sb.append(dto.getMphone() + ",");
				sb.append(dto.getMaddr() + "/");
			}
			result = sb.toString().substring(0, sb.toString().length()-1);
			break;
		case "xmlTag" :
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-*\"?>");
			sb.append("<!DOCTYPE members>");
			sb.append("<members>");
			
			for(MemberDTO dto : list) {
				sb.append("<member>");
				sb.append("<idx>" + dto.getMidx() + "</idx>");
				sb.append("<id>" + dto.getMid() + "</id>");
				sb.append("<pw>" + dto.getMidx() + "</pw>");
				sb.append("<name>" + dto.getMname() + "</name>");
				sb.append("<email>" + dto.getMemail() + "</email>");
				sb.append("<phone>" + dto.getMphone() + "</phone>");
				sb.append("<addr>" + dto.getMaddr() + "</addr>");
				sb.append("</member>");
			}
			
			sb.append("</members>");
			result = sb.toString();
			System.out.println(result);
			break;
		case "xmlProp":
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-*\"?>");
			sb.append("<!DOCTYPE members>");
			sb.append("<members>");
			
			for(MemberDTO dto : list) {
				sb.append("<member");
				sb.append(" idx='"+dto.getMidx()+"'");
				sb.append(" id='"+dto.getMid()+"'");
				sb.append(" pw='"+dto.getMpw()+"'");
				sb.append(" name='"+dto.getMname()+"'");
				sb.append(" email='"+dto.getMemail()+"'");
				sb.append(" phone='"+dto.getMphone()+"'");
				sb.append(" addr='"+dto.getMaddr()+"'");
				sb.append(" />");
				
			}
			sb.append("</members>");
				result = sb.toString();
			break;
		case "json" : 
			sb.append("[");
			for(MemberDTO dto : list) {
				
				sb.append("{");
				sb.append("\"idx\":" + dto.getMidx() + ",");
				sb.append("\"id\":\"" + dto.getMid() + "\",");
				sb.append("\"pw\":\"" + dto.getMpw() + "\",");
				sb.append("\"name\":\"" + dto.getMname() + "\",");
				sb.append("\"email\":\"" + dto.getMemail()+ "\",");
				sb.append("\"phone\":\"" + dto.getMphone() + "\",");
				sb.append("\"addr\":\"" + dto.getMaddr() + "\"");
				sb.append("},");
		}
			result = sb.toString().substring(0, sb.toString().length()-1) + "]";
			System.out.println(result);
			break;
		}
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
