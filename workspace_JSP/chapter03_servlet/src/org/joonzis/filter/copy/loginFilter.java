package org.joonzis.filter.copy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/private/*")
public class loginFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override			//여기서 밑으로 불러가서
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("로그인 필터 확인");
		
		// 1. 로그인된 클라이언트인지 확인(HttpSession 필요 => HttpServletRequest 필요)
		HttpServletRequest req = (HttpServletRequest)request; // 애를 받아와야함
		HttpSession session = req.getSession(); // 애를 받으려면
		
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		
		if (id != null && pw != null) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse rep = (HttpServletResponse)response;
			String cPath = req.getContextPath();
			rep.sendRedirect(cPath + "/login/loginForm.jsp");
		}
	}
	@Override
	public void destroy() {
		
	}
}
