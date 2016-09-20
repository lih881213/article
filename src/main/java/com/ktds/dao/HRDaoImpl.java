package com.ktds.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.vo.DepartmentsVO;
import com.ktds.vo.EmployeesVO;

public class HRDaoImpl implements HRDao {

	@Override
	public List<EmployeesVO> getEmployees() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "HR");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT 	E.EMPLOYEE_ID ");
			query.append("			, E.FIRST_NAME ");
			query.append("			, E.LAST_NAME ");
			query.append("			, E.EMAIL ");
			query.append("			, E.PHONE_NUMBER ");
			query.append("			, E.HIRE_DATE ");
			query.append("			, E.SALARY ");
			query.append("			, E.JOB_ID ");
			query.append("			, E.COMMISSION_PCT ");
			query.append("			, E.MANAGER_ID ");
			query.append("			, E.DEPARTMENT_ID ");
			query.append("			, D.DEPARTMENT_NAME ");
			query.append(" FROM		EMPLOYEES E ");
			query.append(" 			, DEPARTMENTS D ");
			query.append(" WHERE	E.DEPARTMENT_ID = D.DEPARTMENT_ID ");
			query.append(" ORDER    BY E.EMPLOYEE_ID");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
			
			EmployeesVO employeeVO = null;
			DepartmentsVO departmentsVO= null;
			
			while(rs.next()) {
				
				employeeVO = new EmployeesVO();
				departmentsVO = employeeVO.getDepartmentsVO();
				employeeVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeeVO.setFirstName(rs.getString("FIRST_NAME"));
				employeeVO.setLastName(rs.getString("LAST_NAME"));
				employeeVO.setEmail(rs.getString("EMAIL"));
				employeeVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employeeVO.setHireDate(rs.getString("HIRE_DATE"));
				employeeVO.setSalary(rs.getInt("SALARY"));
				employeeVO.setJobId(rs.getString("JOB_ID"));
				employeeVO.setCommissionPCT(rs.getDouble("COMMISSION_PCT"));
				employeeVO.setManagerId(rs.getInt("MANAGER_ID"));
				employeeVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				
				employees.add(employeeVO);
			}
			return employees;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally{
			
			if ( rs !=null ) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if ( pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public List<DepartmentsVO> getDepartments() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "HR");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	DEPARTMENT_ID ");
			query.append(" 			,DEPARTMENT_NAME ");
			query.append(" 			,MANAGER_ID ");
			query.append(" 			,LOCATION_ID ");
			query.append(" FROM		DEPARTMENTS ");
			
			pstmt = conn.prepareStatement(query.toString());
			
			rs = pstmt.executeQuery();
			
			List<DepartmentsVO> departments = new ArrayList<DepartmentsVO>();
			DepartmentsVO departmentsVO = null;
			
			while(rs.next()) {
				departmentsVO = new DepartmentsVO();
				departmentsVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentsVO.setManagerId(rs.getInt("MANAGER_ID"));
				departmentsVO.setLocationId(rs.getInt("LOCATION_ID"));
				
				departments.add(departmentsVO);
				
			}
			return departments;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
}
