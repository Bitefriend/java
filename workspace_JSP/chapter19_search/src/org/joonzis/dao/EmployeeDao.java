package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeDao {
	public List<EmployeeVO> getAllEmployees();
	public List<EmployeeVO> getSelectEmployees(int department_id);
	public List<EmployeeVO> getEmployeesByDynamic(Map<String, String> map);
}
