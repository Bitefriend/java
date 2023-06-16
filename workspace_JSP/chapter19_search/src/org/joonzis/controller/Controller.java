package org.joonzis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceImpl;
import org.joonzis.vo.EmployeeVO;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		String resultCmd = "allList";
		if(cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}
		//단순 화면이동 / 데이터 사용구분
		boolean isForward = false;
		//이동 경로
		String path = "";
		
		EmployeeService service = new EmployeeServiceImpl();
		List<EmployeeVO> list = null;
		
		
		switch (resultCmd) {
			// DB 사용----------------------
			case "allList":
				list = service.getAll();
				request.setAttribute("list", list);
				isForward = true;
				path = "allList.jsp";
				break;
			// 단순화면이동--------------------
			case "inputDept" :
				path="input_Dept.jsp";
				break;
			// 선택?
			case "deptList" :
				int department_id = Integer.parseInt(request.getParameter("department_id"));
				List<EmployeeVO> id = service.getOne(department_id);
				request.setAttribute("id", id);
				
				isForward = true;
				path ="deptList.jsp";
				break;
			case "dynamicList" :
				String key = request.getParameter("key");
				String value = request.getParameter("value");
				Map<String, String> map = new HashedMap<String, String>();
				map.put("key", key);
				map.put("value", value);
				list = service.getDynamic(map);
				
		}
		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		}else {
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
