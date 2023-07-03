package org.joonzis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardMapper {
	//public List<BoardVO> getList(); // 전체 데이터 조회
	public int insert(BoardVO vo); 
	public BoardVO read(long bno);
	public int update(BoardVO vo);
	public int delete(long bno);
	public List<BoardVO> getListPaging(Criteria cri); // 전체 데이터 조회(페이징)
	public int getTotalCount();
	
}
