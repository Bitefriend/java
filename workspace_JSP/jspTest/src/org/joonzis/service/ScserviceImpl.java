package org.joonzis.service;

import java.util.List;
import java.util.Map;


import org.joonzis.dao.SDao;
import org.joonzis.dao.SDaoImpl;
import org.joonzis.vo.SVO;

public class ScserviceImpl implements ScService{
	private SDao sdao = SDaoImpl.getInstance();
	
	@Override
	public List<SVO> getscore(Map<String, Integer> map) {
		return sdao.getscore(map);
	}
	@Override
	public int getSinsert(SVO svo) {
		return sdao.getSinsert(svo);
	}
	@Override
	public SVO selectByIdx(int ss_idx) {
		return sdao.selectByIdx(ss_idx);
	}
	@Override
	public int updateScore(SVO svo) {
		return sdao.updateScore(svo);
	}
	@Override
	public int removeByIdx(int ss_idx2) {
		return sdao.removeByIdx(ss_idx2);
	}

}
