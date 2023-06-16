package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;

public class BDAOIPLE implements BDAO{

		private static BDAOIPLE instance = null;
		public BDAOIPLE() {}
		public static BDAOIPLE getInstance() {
			if (instance == null) {
				instance = new BDAOIPLE();
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
		public List<BVO> allList(Map<String, Integer> map) {
			return getSqlSession().selectList("select_all", map);
		}
		@Override
		public int getTotal() {
		return getSqlSession().selectOne("total_record");
		}
		@Override
		public BVO selectById(int b_idx) {
		return getSqlSession().selectOne("view", b_idx);
		}
		@Override
		public int getUpdateHit(BVO bvo) {
			int result = getSqlSession().update("update2", bvo);
			if(result > 0) {
				getSqlSession().commit();
			}
			return result;
		}
		@Override
		public int getinsert(BVO vo) {
			int result = getSqlSession().insert("insert_bbs", vo);
			if(result > 0) {
				getSqlSession().commit();
			}
		return result;
		}
		@Override
		public int deleteByIdx(int b_idx) {
		return getSqlSession().delete("delete", b_idx);
		}
		@Override
		public int updateByIdx(BVO bvo) {
		return getSqlSession().update("update", bvo);
		}
		@Override
		public List<CVO> cvoView(int b_idx) {
		return getSqlSession().selectList("list_comment",b_idx);
		}
		@Override
		public int cinsertComment(CVO cvo2) {
			int result = getSqlSession().insert("insert_cs", cvo2);
			if(result > 0) {
				getSqlSession().commit();
			}
		return result;
		}
		@Override
		public int deleteByCom(int c_idx) {
			int result = getSqlSession().delete("delete_com", c_idx);
			if(result > 0) {
				getSqlSession().commit();
			}
		return result;
		}

}
