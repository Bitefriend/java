package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.CVO;
import org.joonzis.vo.StudentVO;

public interface StudentService {
	public List<StudentVO> getAll(Map<String, Integer> map);
	public int getTotalRecord();
	public StudentVO selectById(int s_idx);
	public int getUpdateHit(StudentVO bvo);
	public int getinsert(StudentVO vo);
	public int updateByIdx(StudentVO bvo);
	public int deleteByIdx(int s_idx);
	
	public List<StudentVO> gethit(Map<String, Integer> map);

}
