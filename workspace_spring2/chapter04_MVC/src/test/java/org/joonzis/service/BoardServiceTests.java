package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.mapper.BoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	BoardService boardService;
	
	
	 @Test public void testgetList() { 
		 List<BoardVO> list = boardService.getList();
	 
		 for(BoardVO vo : list) { 
			 log.info(vo); 
			 } 
		 }
	 
	
	
	
	 @Test public void testGetInser() { 
		 BoardVO vo = new BoardVO();
		 vo.setTitle("서비스 확인"); 
		 vo.setContent("서비스 확인내용"); 
		 vo.setWriter("서비스 작성자 내용");
	 
		 boardService.register(vo); 
		 }
	 
	
	
	 @Test public void testView() { 
		 BoardVO view = boardService.get(3);
		 log.info(view); 
		 }
	 
	
	@Test
	public void testGetUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setContent("수정 서비스");
		vo.setTitle("수정 서비스 주제");
		vo.setWriter("수정 서비스 작성자");
		vo.setBno(6);
		
		boardService.modify(vo);
	}
	
	@Test
	public void testGetDelete() {
		boolean vo = boardService.remove(2);
		log.info(vo);
	}
}
