package org.joonzis.service;

import java.util.List;
import java.util.Map;


import org.joonzis.vo.SVO;


public interface ScService {
	public List<SVO> getscore(Map<String, Integer> map);
	public int getSinsert(SVO svo);
	public SVO selectByIdx(int ss_idx);
	public int updateScore(SVO svo);
	public int removeByIdx(int ss_idx2);
	
}
