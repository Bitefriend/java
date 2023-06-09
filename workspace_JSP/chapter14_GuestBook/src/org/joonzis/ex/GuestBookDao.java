package org.joonzis.ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.DBService;

public class GuestBookDao {
	
	// 필드
	private static SqlSession sqlsession = null;
	
	//싱글톤
	private synchronized static SqlSession getSqlsession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	// 메소드
	// 모든 메소드를 static 처리해서 별도 과정 없이 GuestBookDao.메소드명()으로
	// 메소드를 사용할 수 있다.
	// sqlsession이 필요하면 위에 정의된 getSqlSession()을 호출하면 된다.
	
	//1. 전체 검색
	public static List<GuestBookVO> selectAll() {
		return getSqlsession().selectList("select_all");
	}
	public static int insert(GuestBookVO vo) {
		int result = getSqlsession().insert("insert", vo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	public static GuestBookVO selectByIdx(int idx) {
		GuestBookVO vo = getSqlsession().selectOne("view", idx);
		
		return vo;
		
	}
	public static int deleteByIdx(int idx) {
		int result = getSqlsession().delete("delete", idx);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
	public static int updateByIdx(GuestBookVO vo) {
		int result = getSqlsession().update("update", vo);
		if(result > 0) {
			getSqlsession().commit();
		}
		return result;
	}
}
