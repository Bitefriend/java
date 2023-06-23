package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.StudentDAO;
import org.joonzis.dao.StudentDAOIPLE;
import org.joonzis.vo.CVO;
import org.joonzis.vo.StudentVO;

public class StudentServiceImpl implements StudentService{
	private StudentDAO dao = StudentDAOIPLE.getInstance();
	
	@Override
	public List<StudentVO> getAll(Map<String, Integer> map) {
		return dao.allList2(map);
	}
	@Override
	public int getTotalRecord() {
		return dao.getTotal2();
	}
	@Override
	public StudentVO selectById(int s_idx) {
		return dao.selectById2(s_idx);
	}
	@Override
	public int getUpdateHit(StudentVO bvo) {
		return dao.getUpdateHit(bvo);
	}
	@Override
	public int getinsert(StudentVO vo) {

		return dao.getinsert(vo);
	}
	@Override
	public int updateByIdx(StudentVO bvo) {
		return dao.updateByIdx(bvo);
	}
	@Override
	public int deleteByIdx(int s_idx) {
		return dao.deleteByIdx(s_idx);
	}
	
	@Override
	public List<StudentVO> gethit(Map<String, Integer> map) {
		return dao.gethit(map);
	}
	

}
