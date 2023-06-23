package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.StudentVO;


public class StudentDAOIPLE implements StudentDAO{
		private static StudentDAOIPLE instance = null;
		
		public StudentDAOIPLE() {}
		
		public static StudentDAOIPLE getInstance() {
			if (instance == null) {
				instance = new StudentDAOIPLE();
			}
			return instance;
		}
		private static SqlSession sqlsession = null;
		private synchronized static SqlSession getSqlSession() {
			if (sqlsession == null) {
				
				sqlsession = DBService.getFactory().openSession(false);
			}
			return sqlsession;		
}
		@Override
		public List<StudentVO> allList2(Map<String, Integer> map) {
			return getSqlSession().selectList("select_all_S", map);
		}
		
		@Override
		public int getTotal2() {
		return getSqlSession().selectOne("total_record_page");
		}
		
		@Override
		public StudentVO selectById2(int s_idx) {

		return getSqlSession().selectOne("allList_view", s_idx);
		}
		@Override
		public int getUpdateHit(StudentVO bvo) {
			int result = getSqlSession().update("update_hit", bvo);
			if(result > 0) {
				getSqlSession().commit();
			}
			return result;
		}
		@Override
		public int getinsert(StudentVO vo) {
			int result = getSqlSession().insert("insert_student", vo);
			if(result > 0) {
				getSqlSession().commit();
			}
		return result;
		}
		@Override
		public int updateByIdx(StudentVO bvo) {
		return getSqlSession().update("update_allList", bvo);
		}
		@Override
		public int deleteByIdx(int s_idx) {
		return getSqlSession().delete("delete_allList", s_idx);
		}
		
		@Override
		public List<StudentVO> gethit(Map<String, Integer> map) {
		return getSqlSession().selectList("hit_list", map);
		}
		

}
