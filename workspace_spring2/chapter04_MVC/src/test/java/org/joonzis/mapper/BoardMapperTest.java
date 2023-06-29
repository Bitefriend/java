package org.joonzis.mapper;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.joonzis.domain.BoardVO;
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
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	BoardMapper mapper;
	
	
	  @Test 
	 public void testGetList() {
	 
	 //mapper.getList().forEach(board -> log.info(board));;
	 
	 List<BoardVO> list = mapper.getList();
	 
	 //vo 출력 
	 for (BoardVO vo: list) { 
	 log.info(vo); 
	 }  
	 }
	
	 @Test 
	 public void testGetInsert() {
	  
	 BoardVO vo = new BoardVO();
	  
	 vo.setTitle("테스트 제목5"); 
	  
	 vo.setContent("테스트 내용5"); 
	  
	 vo.setWriter("user05");
	  
	 mapper.insert(vo); 
	 }
	 
	 @Test 
	 public void testView() { 
	  
	 BoardVO view = mapper.read(1);
	  
	 log.info(view);
	  
	 }
	
	 @Test public void testupdate() { 
	 BoardVO vo = new BoardVO();
	  
	 vo.setContent("테스트 내용22"); 
	 vo.setTitle("테스트 주제22"); 
	 vo.setWriter("user22");
	 vo.setBno(2);
	  
	 mapper.update(vo);
	  
	 }
	 
	@Test
	public void testdelete() {
		int vo = mapper.delete(8);
		log.info(vo);
	}
}
