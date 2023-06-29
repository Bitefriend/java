package org.joonzis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.joonzis.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	public int insert(BoardVO vo);
	public BoardVO read(long bno);
	public int update(BoardVO vo);
	public int delete(long bno);
	
	
}
