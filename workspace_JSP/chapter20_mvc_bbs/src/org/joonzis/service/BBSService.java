package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;

public interface BBSService {
	public List<BVO> getAll(Map<String, Integer> map);
	public int getTotalRecord();
	public BVO selectById(int b_idx);
	public int getUpdateHit(BVO bvo);
	public int getinsert(BVO vo);
	public int deleteByIdx(int b_idx);
	public int updateByIdx(BVO bvo);
	public List<CVO> cvoView(int b_idx);
	public int cinsertComment(CVO cvo2);
	public int deleteByCom(int c_idx);
}
