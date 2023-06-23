package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.CVO;
import org.joonzis.vo.FVO;

public interface FDao {
	public List<FVO> getTotalfree(Map<String, Integer> map);
	public int getAll_F();
	public FVO selectById_free(int f_idx);
	public int getUpdateHit_free(FVO fvo);
	public int getinsert(FVO fvo);
	public int updateByIdx_free(FVO fvo);
	public int deleteByIdx_free(int f_idx2);
	
	//댓글 
	
	public int cinsertComment(CVO cvo2);
	public List<CVO> cvoView(int f_idx);
	public int deleteByCom_free(int c_idx);
}
