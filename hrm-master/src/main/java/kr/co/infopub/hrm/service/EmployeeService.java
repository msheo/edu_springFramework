package kr.co.infopub.hrm.service;

import java.util.List;
import java.util.Map;

import kr.co.infopub.hrm.dto.DepCountDto;
import kr.co.infopub.hrm.dto.DepartmentDto;
import kr.co.infopub.hrm.dto.EmployeeDto;

public interface EmployeeService {
	public List<EmployeeDto> findAllEmployees() throws Exception;
	public List<DepartmentDto> findAllDepartments () throws Exception;
	public List<EmployeeDto> findEmployeesByDepartName(Map<String, String> map)throws Exception;
	public int getEmployeesTotal()throws Exception;
	public List<DepartmentDto> findAllDepartments2()throws Exception;
	public List<DepCountDto> findAllDepCounts() throws Exception;
	public  List<String> findAllJobs ()throws Exception;
	public  List<EmployeeDto> findTreeManagerInEmployee () throws Exception;
	
	public  List<EmployeeDto> findEmployeesByManagerId (Map<String, String> map)throws Exception;
	public  List<EmployeeDto> findEmployeesByEmpId (Map<String, String> map) throws Exception;
	public  EmployeeDto findEmployeeById (Map<String, String> map)throws Exception;
	public  List<EmployeeDto> findManagersByName(Map<String, String> map)throws Exception;
	
	public  int getTreeMaxLevel ()throws Exception;
	public  int addEmployee (EmployeeDto emp)throws Exception;
	public  boolean updateEmployee(EmployeeDto emp)throws Exception;
	public  boolean updateJobHistory(EmployeeDto emp)throws Exception;
	public  boolean deleteEmployee (Map<String, String> emp)throws Exception;
}
