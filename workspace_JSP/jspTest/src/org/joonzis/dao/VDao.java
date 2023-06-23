package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.VVO;

public interface VDao {
	public List<VVO> getTotalfree(Map<String, Integer> map);
	public int getAll_V();
	public VVO selectById_vol(int v_idx);
	public int getUpdateHit_vol(VVO vvo);
	public int getinsert_vol(VVO vvo);
	public int updateByIdx_vol(VVO vvo);
	public int deleteByIdx_vol(int v_idx2);
}
