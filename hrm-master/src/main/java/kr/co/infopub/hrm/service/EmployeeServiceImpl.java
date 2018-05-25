package kr.co.infopub.hrm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.infopub.hrm.dao.EmployeeDao;
import kr.co.infopub.hrm.dto.DepCountDto;
import kr.co.infopub.hrm.dto.DepartmentDto;
import kr.co.infopub.hrm.dto.EmployeeDto;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
	private EmployeeDao employeeDao;
    
	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return employeeDao.findAllEmployees();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentDto> findAllDepartments() throws Exception {
		return employeeDao.findAllDepartments();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findEmployeesByDepartName(Map<String, String> map) throws Exception {
		return employeeDao.findEmployeesByDepartName(map);
	}

	@Override
	@Transactional(readOnly=true)
	public int getEmployeesTotal() throws Exception {
		return employeeDao.getEmployeesTotal();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentDto> findAllDepartments2() throws Exception {
		return employeeDao.findAllDepartments2();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepCountDto> findAllDepCounts() throws Exception {
		return employeeDao.findAllDepCounts();
	}

	@Override
	@Transactional(readOnly=true)
	public List<String> findAllJobs() throws Exception {
		return employeeDao.findAllJobs();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findTreeManagerInEmployee() throws Exception {
		return employeeDao.findTreeManagerInEmployee();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findEmployeesByManagerId(Map<String, String> map) throws Exception {
		return employeeDao.findEmployeesByManagerId(map);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findEmployeesByEmpId(Map<String, String> map) throws Exception {
		return employeeDao.findEmployeesByEmpId(map);
	}

	@Override
	@Transactional(readOnly=true)
	public EmployeeDto findEmployeeById(Map<String, String> map) throws Exception {
		return employeeDao.findEmployeeById(map);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findManagersByName(Map<String, String> map) throws Exception {
		return employeeDao.findManagersByName(map);
	}

	@Override
	@Transactional(readOnly=true)
	public int getTreeMaxLevel() throws Exception {
		return employeeDao.getTreeMaxLevel();
	}

	@Override
	@Transactional
	public int addEmployee(EmployeeDto emp) throws Exception {
		       employeeDao.addEmployee(emp);
		return employeeDao.findAfterAdd();
	}

	@Override
	@Transactional
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public boolean updateJobHistory(EmployeeDto emp) throws Exception {
		return employeeDao.updateJobHistory(emp);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(Map<String, String> emp) throws Exception {
		return employeeDao.deleteEmployee(emp);
	}


	
}
