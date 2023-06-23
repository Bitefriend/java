package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.VVO;

public class VDaoImpl implements VDao{
private static VDaoImpl instance = null;
	
	public VDaoImpl() {}
	
	public static VDaoImpl getInstance() {
		if (instance == null) {
			instance = new VDaoImpl();
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
		public int getAll_V() {
		return getSqlSession().selectOne("total_record_vol");
		}
	@Override
		public List<VVO> getTotalfree(Map<String, Integer> map) {
			return getSqlSession().selectList("select_all_V", map);
		}
	@Override
		public VVO selectById_vol(int v_idx) {
			return getSqlSession().selectOne("volunteer_view", v_idx);
		}
	@Override
		public int getUpdateHit_vol(VVO vvo) {
		int result = getSqlSession().update("update_hit_vol", vvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
		}
	@Override
		public int getinsert_vol(VVO vvo) {
			int result = getSqlSession().insert("insert_vol",vvo);
			if(result > 0) {
				getSqlSession().commit();
			}
			return result;
		}
	@Override
		public int updateByIdx_vol(VVO vvo) {
			return getSqlSession().update("update_vol", vvo);
		}
	@Override
		public int deleteByIdx_vol(int v_idx2) {
			int result = getSqlSession().delete("delete_vol", v_idx2);
			if(result > 0) {
				getSqlSession().commit();
			}
			return result;
		}
}
