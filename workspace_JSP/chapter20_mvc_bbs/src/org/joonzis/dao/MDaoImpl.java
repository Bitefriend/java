package org.joonzis.dao;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.MVO;

public class MDaoImpl implements MDao{

	private static MDaoImpl instance = null;
	public MDaoImpl() {}
	public static MDaoImpl getInstance() {
		if (instance == null) {
			instance = new MDaoImpl();
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
	public int getJoin(MVO mvo) {
		int result = getSqlSession().insert("insert_mvo", mvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public int ckMember(MVO mvo) {

		return getSqlSession().selectOne("login_count", mvo);
	}
	@Override
	public MVO getmidx(MVO mvo) {
		return getSqlSession().selectOne("view_login", mvo);
	}
}
