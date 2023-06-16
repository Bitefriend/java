package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.EmployeeVO;

public class EmployeeDaoImpl implements EmployeeDao{
	
	// DAO 객체 생성
	private static EmployeeDaoImpl instance = null;
	public EmployeeDaoImpl() {}
	public static EmployeeDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}
	//필드
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if (sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}

	@Override
	public List<EmployeeVO> getAllEmployees() {
		return getSqlSession().selectList("select_all");
	}
	@Override
	public List<EmployeeVO> getSelectEmployees(int department_id) {
		
		return getSqlSession().selectList("select_one", department_id);
	}
	@Override
	public List<EmployeeVO> getEmployeesByDynamic(Map<String, String> map) {
		return getSqlSession().selectList("select_Dynamic", map);
	}
	
	
}
