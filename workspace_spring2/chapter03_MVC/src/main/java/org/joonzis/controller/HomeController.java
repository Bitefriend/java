package org.joonzis.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.joonzis.dto.StudentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//@RequestMapping : url-mapping
	// 메소드를 대상으로 어노테이션을 붙인다.
	// value = "/" : 컨텍스트 패스를 의미, 서버:포트/디폴트 패키지
	// method : RequestMethod.GET : get/post 방식
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "member/input";
	}
	
	
	@RequestMapping(value = "member/result", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, 
						@RequestParam("pw") String pw, 
						Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/output";
	}
	
	// 주소에 https://localhost:8080/controller/a/b/c/d/e 를 입력 시 view01.jsp로 이동
	// method 생력가능 (기본 값 : get)
	// value 생략 가능 @RequestMapping("/a/b/c/d/e")
	@RequestMapping(value = "/a/b/c/d/e")
	public String goView01() {
		// 1. 리턴 타입 : 뷰 (view)를 리턴하기 때문에 언제나 String을 리턴한다.
		// 2. 메소드명 : goView01은 아무런 의미가 없다.(메소드들의 이름만 다르면 된다.)
		// 3. 리턴 : "/view01", "view01"의 차이점은 없다.
		return"/view01";
	}
	
	// 메소드 이름 goView02
	// url에 "admin/view02"로 접근 시
	// view02.jsp로 데이터 전달하여 화면에 출력
	// 속성 명 : id, 속성 값 : admin
	// 속성 명 : pw, 속성 값 : 1234
	
	@RequestMapping(value = "admin/view02")
	public String view02(Model model) {
		 
		/*
		 * model 클래스
		 * 
		 *  1. request의 attribute의 역할을 수행하는 클라스
		 *  2. addAttribute("속성명", "값") 방식으로 Attribute 저장
		 *  	model.addAttribute == request.setAttribute
		 *  3. controller가 jsp에게 파라미터를 전달하려면 무조건 model을 사용한다.
		 *  	(스프링 버전 2전에는 ModelAndView를 사용했다.)
		 *  4. Model model 을 매개 변수로 선언한다
		 */
		

		model.addAttribute("id", "admin");
		model.addAttribute("pw", "1234");
		

		return "/view02";
	}
	@RequestMapping("index")
	public String goIndex() {
		return "/index";
	}
	@RequestMapping(value = "v01", method = RequestMethod.POST)
	public String goV01(Model model, StudentDto sDto) {
		model.addAttribute("sDto", sDto);
		return "result";
	}
	@RequestMapping(value = "v02", method = RequestMethod.POST)
	public String goV02(@ModelAttribute("s") StudentDto dto) {
		
		return "result";
	}
}
