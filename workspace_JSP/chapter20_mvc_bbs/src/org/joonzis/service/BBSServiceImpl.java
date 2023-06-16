package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.BDAO;
import org.joonzis.dao.BDAOIPLE;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;


public class BBSServiceImpl implements BBSService{
	private BDAO dao = BDAOIPLE.getInstance();
	@Override
	public List<BVO> getAll(Map<String, Integer> map) {
		return dao.allList(map);
	}
	@Override
	public int getTotalRecord() {
		return dao.getTotal();
	}
	@Override
	public BVO selectById(int b_idx) {
		return dao.selectById(b_idx);
	}
	@Override
	public int getUpdateHit(BVO bvo) {
		return dao.getUpdateHit(bvo);
	}
	@Override
	public int getinsert(BVO vo) {
		return dao.getinsert(vo);
	}
	@Override
	public int deleteByIdx(int b_idx) {
		return dao.deleteByIdx(b_idx);
	}
	@Override
	public int updateByIdx(BVO bvo) {
		return dao.updateByIdx(bvo);
	}
	@Override
	public List<CVO> cvoView(int b_idx) {
		return dao.cvoView(b_idx);
	}
	@Override
	public int cinsertComment(CVO cvo2) {
		return dao.cinsertComment(cvo2);
	}
	@Override
	public int deleteByCom(int c_idx) {
		return dao.deleteByCom(c_idx);
	}
}


