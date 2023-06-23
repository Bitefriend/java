package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.FDao;
import org.joonzis.dao.FDaoImpl;
import org.joonzis.vo.CVO;
import org.joonzis.vo.FVO;

public class FreeServiceImpl implements FreeService{
	private FDao fdao = FDaoImpl.getInstance();
	
	@Override
	public List<FVO> getTotalfree(Map<String, Integer> map) {
		return fdao.getTotalfree(map);
	}
	@Override
	public int getAll_F() {
		return fdao.getAll_F();
	}
	@Override
	public FVO selectById_free(int f_idx) {
		// TODO Auto-generated method stub
		return fdao.selectById_free(f_idx);
	}
	@Override
	public int getUpdateHit_free(FVO fvo) {
		return fdao.getUpdateHit_free(fvo);
	}
	@Override
	public int getinsert(FVO fvo) {
		return fdao.getinsert(fvo);
	}
	@Override
	public int updateByIdx_free(FVO fvo) {
		return fdao.updateByIdx_free(fvo);
	}
	@Override
	public int deleteByIdx_free(int f_idx2) {
		return fdao.deleteByIdx_free(f_idx2);
	}
	
	//댓글
	@Override
	public int cinsertComment(CVO cvo2) {
		return fdao.cinsertComment(cvo2);
	}
	@Override
	public List<CVO> cvoView(int f_idx) {
		return fdao.cvoView(f_idx);
	}
	@Override
	public int deleteByCom_free(int c_idx) {

		return fdao.deleteByCom_free(c_idx);
	}

}
