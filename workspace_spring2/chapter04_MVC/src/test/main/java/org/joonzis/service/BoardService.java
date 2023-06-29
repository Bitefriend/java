package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	public int register(BoardVO vo);
	public BoardVO get(long bno);
	public boolean remove(long bno);
	public boolean modify(BoardVO vo);
}
