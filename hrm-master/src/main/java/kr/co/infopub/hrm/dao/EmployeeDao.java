package kr.co.infopub.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.infopub.hrm.dto.DepCountDto;
import kr.co.infopub.hrm.dto.DepartmentDto;
import kr.co.infopub.hrm.dto.EmployeeDto;
import kr.co.infopub.hrm.mapper.HrmMapper;

@Repository
public class EmployeeDao implements HrmMapper{
	
	private String ns="kr.co.infopub.hrm.mapper.HrmMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception{
	        return sqlSession.selectList(ns+"findAllEmployees");
	}

	@Override
	public List<DepartmentDto> findAllDepartments() throws Exception{
		return  sqlSession.selectList(ns+"findAllDepartments");
	}
	
	@Override
	public List<EmployeeDto> findEmployeesByDepartName(Map<String, String> map) throws Exception{
		 return sqlSession.selectList(ns+"findEmployeesByDepartName",map);
	}

	@Override
	public int getEmployeesTotal() throws Exception{
		return sqlSession.selectOne(ns+"getEmployeesTotal");
	}

	@Override
	public List<DepartmentDto> findAllDepartments2() throws Exception{
		return  sqlSession.selectList(ns+"findAllDepartments2");
	}

	@Override
	public List<DepCountDto> findAllDepCounts() throws Exception{
		return  sqlSession.selectList(ns+"findAllDepCounts");
	}

	@Override
	public List<String> findAllJobs() throws Exception{
		return  sqlSession.selectList(ns+"findAllJobs");
	}

	@Override
	public List<EmployeeDto> findTreeManagerInEmployee() throws Exception{
		return  sqlSession.selectList(ns+"findTreeManagerInEmployee");
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(Map<String, String> map) throws Exception{
		return  sqlSession.selectList(ns+"findEmployeesByManagerId",map);
	}

	@Override
	public List<EmployeeDto> findEmployeesByEmpId(Map<String, String> map)throws Exception{
		return  sqlSession.selectList(ns+"findEmployeesByEmpId",map);
	}

	@Override
	public EmployeeDto findEmployeeById(Map<String, String> map) throws Exception{
		return  sqlSession.selectOne(ns+"findEmployeeById",map);
	}

	@Override
	public List<EmployeeDto> findManagersByName(Map<String, String> map) throws Exception{
		return  sqlSession.selectList(ns+"findManagersByName",map);
	}

	@Override
	public int getTreeMaxLevel() throws Exception{
		return  sqlSession.selectOne(ns+"getTreeMaxLevel");
	}

	@Override
	public int findAfterAdd() throws Exception{
		return sqlSession.selectOne(ns+"findAfterAdd");
	}

	@Override
	public int addEmployee(EmployeeDto emp)throws Exception{
		sqlSession.insert(ns+"addEmployee",emp);
		return 0;
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception{
		sqlSession.update(ns+"updateEmployee",emp);
		return true;
	}

	@Override
	public boolean updateJobHistory(EmployeeDto emp) throws Exception{
		sqlSession.update(ns+"updateJobHistory",emp);
		return true;
	}

	@Override
	public boolean deleteEmployee(Map<String, String> emp) throws Exception{
		sqlSession.delete(ns+"deleteEmployee",emp);
		return true;
	}
}
