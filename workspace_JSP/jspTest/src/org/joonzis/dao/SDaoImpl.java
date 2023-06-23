package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.SVO;

public class SDaoImpl implements SDao{

	private static SDaoImpl instance = null;
	public SDaoImpl() {}
	public static SDaoImpl getInstance() {
		if (instance == null) {
			instance = new SDaoImpl();
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
	public List<SVO> getscore(Map<String, Integer> map) {
		return getSqlSession().selectList("select_Score", map);
	}
	@Override
	public int getSinsert(SVO svo) {
		int result = getSqlSession().insert("insert_Score", svo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public SVO selectByIdx(int ss_idx) {
		return getSqlSession().selectOne("score_view", ss_idx);
	}
	@Override
	public int updateScore(SVO svo) {
		return getSqlSession().update("update_score", svo);
	}
	@Override
	public int removeByIdx(int ss_idx2) {
		int result = getSqlSession().delete("delete_score", ss_idx2);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
