package org.joonzis.controller;


import org.joonzis.service.BoardServiceTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTests {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	//가짜 MVC (가상으로 URL과 파라미터 등을 브라우저에서 사용하는 것처럼 실행가능)
	private MockMvc mockMvc;
	
	@Before // junit
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	 @Test 
	 public void testList() throws Exception{
		 log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).
			 andReturn().
			 getModelAndView().
			 getModelMap() 
			 );
	 }
	 
	
	 @Test 
	 public void testRegister() throws Exception{
	  
	 String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
			 .param("title", "테스트 새글") 
			 .param("content", "테스트내용") 
			 .param("writer", "테스터")). 
			 andReturn().getModelAndView().getViewName(); 
	 }
	 
	
	 @Test 
	 public void testRegisterget() throws Exception{
		 log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).
				 andReturn().getModelAndView().getModelMap() ); 
		 }
	 
	
	@Test
	public void testModify() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("title", "타이틀이다2")
				.param("content", "컨텐츠다2")
				.param("writer", "작성자다2")
				.param("bno", "7")
				)
				.andReturn().getModelAndView().getModelMap()
				);
	}
	
	 @Test 
	 public void testRemove() throws Exception{
		 log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
			 .param("bno", "10")) 
			 .andReturn().getModelAndView().getModelMap() 
			 ); 
	 }
	 
	
	
	
	
	
}
