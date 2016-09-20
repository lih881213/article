package com.ktds.dao;

import java.util.List;

import com.ktds.vo.DepartmentsVO;
import com.ktds.vo.EmployeesVO;

public interface HRDao {

	public List<EmployeesVO> getEmployees();
	
	public List<DepartmentsVO> getDepartments();
	
	
	
}
