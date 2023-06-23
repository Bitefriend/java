package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.CVO;
import org.joonzis.vo.FVO;

public class FDaoImpl implements FDao{
	private static FDaoImpl instance = null;
	
	public FDaoImpl() {}
	
	public static FDaoImpl getInstance() {
		if (instance == null) {
			instance = new FDaoImpl();
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
	public List<FVO> getTotalfree(Map<String, Integer> map) {
		return getSqlSession().selectList("select_all_F", map);
	}
	@Override
	public int getAll_F() {
		return getSqlSession().selectOne("total_record_Free");
	}
	@Override
	public FVO selectById_free(int f_idx) {
		return getSqlSession().selectOne("free_write_view", f_idx);
	}
	@Override
	public int getUpdateHit_free(FVO fvo) {
		int result = getSqlSession().update("update_hit_free", fvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public int getinsert(FVO fvo) {
		int result = getSqlSession().insert("insert_free",fvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public int updateByIdx_free(FVO fvo) {
		return getSqlSession().update("update_Free", fvo);
	}
	@Override
	public int deleteByIdx_free(int f_idx2) {
		int result = getSqlSession().delete("delete_free", f_idx2);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result; 
	}
	
	//댓글
	@Override
	public List<CVO> cvoView(int f_idx) {
		return getSqlSession().selectList("list_comment",f_idx);
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
	public int deleteByCom_free(int c_idx) {
		int result = getSqlSession().delete("delete_com", c_idx);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
