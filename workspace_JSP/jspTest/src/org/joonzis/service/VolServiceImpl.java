package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.VDao;
import org.joonzis.dao.VDaoImpl;
import org.joonzis.vo.VVO;

public class VolServiceImpl implements VolService{
	private VDao vdao = VDaoImpl.getInstance();
	
	@Override
	public List<VVO> getTotalfree(Map<String, Integer> map) {
		return vdao.getTotalfree(map);
	}
	@Override
	public int getAll_V() {
		return vdao.getAll_V();
	}
	@Override
	public VVO selectById_vol(int v_idx) {
		return vdao.selectById_vol(v_idx);
	}
	@Override
	public int getUpdateHit_vol(VVO vvo) {
		return vdao.getUpdateHit_vol(vvo);
	}
	@Override
	public int getinsert_vol(VVO vvo) {
		return vdao.getinsert_vol(vvo);
	}
	@Override
	public int updateByIdx_vol(VVO vvo) {
		return vdao.updateByIdx_vol(vvo);
	}
	@Override
	public int deleteByIdx_vol(int v_idx2) {
		return vdao.deleteByIdx_vol(v_idx2);
	}
}
