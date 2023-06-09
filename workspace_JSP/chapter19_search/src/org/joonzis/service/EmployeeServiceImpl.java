package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao dao = EmployeeDaoImpl.getInstance();
	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAllEmployees();
	}
	@Override
	public List<EmployeeVO> getOne(int department_id) {
		return dao.getSelectEmployees(department_id);
	}
	@Override
	public List<EmployeeVO> getDynamic(Map<String, String> map) {
		return dao.getEmployeesByDynamic(map);
	}
}
