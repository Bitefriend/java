package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex08_request")
public class Ex08_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex08_request() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		
		String name = request.getParameter("name");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("mat");
		
		/*
		 * int avg = Integer.parseInt(request.getParameter("kor + eng + mat / 3"));
		 */		
		out.print("<ul>");
		out.print("<li>" + name + "</li>");
		out.print("<li>" + kor + "</li>");
		out.print("<li>" + eng + "</li>");
		out.print("<li>" + mat + "</li>");
		/* out.print("<li>" + "평균은 : " + avg + "</li>"); */
		/*
		 * if(avg >= 90 ) { out.print("<li>" + "학점은 : A" + "</li>"); }else if(avg >= 80)
		 * { out.print("<li>" + "학점은 : B" + "</li>"); }else if(avg >= 70) {
		 * out.print("<li>" + "학점은 : C" + "</li>"); }else if(avg >= 60) {
		 * out.print("<li>" + "학점은 : D" + "</li>"); }else if(avg < 60) {
		 * out.print("<li>" + "학점은 : F" + "</li>"); }
		 */
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
