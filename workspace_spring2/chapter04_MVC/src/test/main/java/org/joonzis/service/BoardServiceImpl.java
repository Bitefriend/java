package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList...");
		return mapper.getList();
	}

	@Override
	public int register(BoardVO vo) {
		log.info("insert...");
		return mapper.insert(vo);
	}

	@Override
	public BoardVO get(long bno) {
		log.info("get....");
		return mapper.read(bno);
	}

	@Override
	public boolean remove(long bno) {
		log.info("remove...");
		return mapper.delete(bno)==1;
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify...");
		return mapper.update(vo)==1;
	}
	
}
