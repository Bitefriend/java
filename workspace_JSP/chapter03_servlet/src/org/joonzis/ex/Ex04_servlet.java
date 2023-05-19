package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04_servlet")
public class Ex04_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Calendar 객체를 이용하여 웹 브라우저에
		// 2023년 05월 17일 출력
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 웹 브라우저에 출력하기 위한 객체
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR); 
		int mon = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print(year + "년" +mon+"월" + day + "일");
		out.print("</body>");
		out.print("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
