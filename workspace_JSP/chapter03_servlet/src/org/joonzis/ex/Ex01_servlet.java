package org.joonzis.ex;

import java.io.IOException;

import javax.servlet.ServletConfig;

// 서블릿 실행
// 호스트이름 : 포트번호/프로젝트이름/서블릿
//호스트이름:포트번호/contextPath/URLMapping
//URLMapping의 기본 값은 서블릿 이름이다.
//서블릿 이름 = 본명, URLMapping = 별명 ( 본명과 별명은 같을 수 있다 ! 보통 별명을 많이 쓴다!)

// ex) localhost:8080/chapter03_servlet/Ex01_servlet

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_servlet
 */
@WebServlet("/Ex01_servlet")
public class Ex01_servlet extends HttpServlet {
	// Serializable 인터페이스를 구현하게 되면 노란색 warning 발생
	// 직렬화에서 사용하는 고유 아이디로, 선언하지 않으면 JVM에서 자동생성 및 대입
	// 그래서 선언하지 않아도 동작에 문제 없다
	private static final long serialVersionUID = 1L;
       
	// 생성자
	// 생성자 호출 뒤 -> init() 메소드가 자동 호출
  
    public Ex01_servlet() {
        super();
        System.out.println("생성자 호출");
    }
    
    //init() 메소드
    // servlet 생성 후 한 번만 호출
    // 초기화 용도로 사용
    // init()메소드 호출 뒤 > service() 메소드가 자동 호출
    public void init(ServletConfig config) throws ServletException{
    	System.out.println("init()호출");
    }
    
    // service()메소드
    // 매개변수 1 - HttpServletRequest req : 요청 정보 (브라우저 > 서버)
    // 매개변수 2 - HttpServletResponse resp : 응답 정보 ( 서버 > 브라우저)
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	System.out.println("service()호출");
    	
    	//사용자 요청정보(request)를 분석하여 get 방식이면 doGet()을 호출
    	// post 방식이면 doPost() 메소드를 호출
    	
    	//<form method="post">
    	//<form method="POST"> 대소문자 구분없이 처리
    	System.out.println(req.getMethod());
    	if (req.getMethod().equalsIgnoreCase("get")) {
			doGet(req,resp);
		}else {
			doPost(req,resp);
		}
  
	}
	//method를 지정하지 않거나, <form method="get"> 인 경우 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//<form method="post"> 인 경우 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
