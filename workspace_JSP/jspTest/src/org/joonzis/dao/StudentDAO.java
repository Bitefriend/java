package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.CVO;
import org.joonzis.vo.StudentVO;


public interface StudentDAO {
	public List<StudentVO> allList2(Map<String, Integer> map);
	public int getTotal2();
	public StudentVO selectById2(int s_idx);
	public int getUpdateHit(StudentVO bvo);
	public int getinsert(StudentVO vo);
	public int updateByIdx(StudentVO bvo);
	public int deleteByIdx(int s_idx);
	
	public List<StudentVO> gethit(Map<String, Integer> map);
	
	
	
	

}
