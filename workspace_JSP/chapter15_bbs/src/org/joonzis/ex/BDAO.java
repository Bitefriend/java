package org.joonzis.ex;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.DBService;

public class BDAO {
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlsession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	//0. 전체 데이터 개수가져오기
	public static int getTotalRecord() {
		return getSqlsession().selectOne("total_record");
	}
	//1. 전체 검색
	public static List<BVO> getList(Map<String, Integer> map) {
		return getSqlsession().selectList("list_bbs", map);
	}
	public static int getinsert(BVO vo) {
		int result = getSqlsession().insert("insert_bbs", vo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	public static BVO selectById(int b_idx) {
		BVO vo = getSqlsession().selectOne("view", b_idx);
		
		return vo;
	}
	// view Comment
	public static List<CVO> cvoView(int b_idx) {
		return getSqlsession().selectList("list_comment",b_idx);
	}
	public static int deleteByIdx(int b_idx) {
		int result = getSqlsession().delete("delete", b_idx);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	// delete Comment
	public static int deleteByCom(int c_idx) {
			int result = getSqlsession().delete("delete2", c_idx);
			if(result > 0) {
				getSqlsession().commit();
			}
			return result;
	}
	public static int updateByIdx(BVO bvo) {
		int result = getSqlsession().update("update", bvo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	public static int getUpdateHit(BVO bvo) {
		int result = getSqlsession().update("update2", bvo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	public static int cinsertComment(CVO cvo) {
		int result = getSqlsession().insert("insert_cs", cvo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
}
