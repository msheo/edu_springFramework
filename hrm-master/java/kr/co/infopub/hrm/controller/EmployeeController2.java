package kr.co.infopub.hrm.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.infopub.hrm.dto.DepCountDto;
import kr.co.infopub.hrm.dto.DepartmentDto;
import kr.co.infopub.hrm.dto.EmployeeDto;
import kr.co.infopub.hrm.help.BoolResult;
import kr.co.infopub.hrm.help.NumberResult;
import kr.co.infopub.hrm.service.EmployeeService;

public class EmployeeController2 {
 public static final Logger logger = 
		 LoggerFactory.getLogger(EmployeeController2.class);
 private String to__(String v){
	return v.replaceAll(" ", "%20");
 }
 private String __to(String v){
	return v.replaceAll("%20", " ");
 }
 @Autowired
 private EmployeeService  employeeService; 
 /*	http://localhost:8199/humans/api/findAllEmployees
	[
	    {
	        "email": "SKING",
	        "salary": 24000,
	        "order2": null,
	        "firstName": "Steven",
	        "phoneNumber": "515.123.4567",
	        "hireDate": "2003-06-17",
	        "jobId": "AD_PRES",
	        "employeeId": 100,
	        "lastName": "King",
	        "managerId": 0,
	        "commissionPct": 0,
	        "departmantId": 90
	    },*/
 @ApiOperation(value = "모든 사원의 정보를 반환한다.", response = List.class)
 @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
 public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception {
	logger.info("1-------------findAllEmployees----------------"+new Date());
	List<EmployeeDto> emps = employeeService.findAllEmployees();
	if (emps.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
 }
 /*	http://localhost:8199/humans/api/findAllDepartments
    [
	    {
	        "department_id": 10,
	        "department_name": "Administration",
	        "manager_id": 0,
	        "location_id": 0
	    },*/
 @ApiOperation(value = "모든 부서의 정보를 반환한다. 적어도 1명 이상의 사원이 있는 부서만 반환한다.", 
		                                              response = List.class)
 @RequestMapping(value = "/findAllDepartments", method = RequestMethod.GET)
 public ResponseEntity<List<DepartmentDto>> findAllDepartments() throws Exception {
	logger.info("1-------------findAllDepartments--------"+new Date());
	List<DepartmentDto> emps = employeeService.findAllDepartments();
	if (emps.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<DepartmentDto>>(emps, HttpStatus.OK);
 }
 /*	http://localhost:8199/humans/api/findTreeManagerInEmployee
    [
	    {
	        "email": null,
	        "salary": 0,
	        "order2": "/001100",
	        "firstName": "Steven",
	        "phoneNumber": null,
	        "hireDate": null,
	        "jobId": null,
	        "employeeId": 100,
	        "lastName": "King",
	        "managerId": 0,
	        "commissionPct": 0,
	        "departmantId": 90
	    },*/
 @ApiOperation(value = " 사원과 관리자 관계를 트리로 반환한다.", response = List.class)
 @RequestMapping(value = "/findTreeManagerInEmployee", method = RequestMethod.GET)
 public ResponseEntity<List<EmployeeDto>> findTreeManagerInEmployee() 
		                                                  throws Exception {
	logger.info("1-------findTreeManagerInEmployee--------"+new Date());
	List<EmployeeDto> emps = employeeService.findTreeManagerInEmployee();
	if (emps.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
 }
    


/*	http://localhost:8199/humans/api/findEmployeesByDepartName/Human Resources
 http://localhost:8199/humans/api/findEmployeesByDepartName/Human%20Resources
	[
	    {
	        "email": "SMAVRIS",
	        "salary": 6500,
	        "order2": null,
	        "firstName": "Susan",
	        "phoneNumber": "515.123.7777",
	        "hireDate": "2002-06-07",
	        "jobId": "HR_REP",
	        "employeeId": 203,
	        "lastName": "Mavris",
	        "managerId": 101,
	        "commissionPct": 0,
	        "departmantId": 40
	    }
	]*/
    @ApiOperation(value = "해당부서의 사원 정보를 반환한다. 부서이름을 입력하지 않으면 NOTYET을 입력한다.", response = List.class)
	@RequestMapping(value = "/findEmployeesByDepartName/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDto>> findEmployeesByDepartName(@PathVariable String name) throws Exception {
		logger.info("1-------------findEmployeesByDepartName------------------------------------------------------"+new Date());
		logger.info("1-------------findEmployeesByDepartName-------------------------------------->>----------------"+name);
		if(name.equalsIgnoreCase("NotYet")){
			name="NotYet".toUpperCase();
		}else{
			name=__to(name);
		}
		Map<String, String> map=new HashMap<String, String>();
		map.put("department_name", name);
		
		logger.info("1-------------findEmployeesByDepartName------------------------------------->>-----------------"+name);
		List<EmployeeDto> emps = employeeService.findEmployeesByDepartName(map);
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
/*	
http://localhost:8199/humans/api/getEmployeesTotal
   {
	    "name": "getEmployeesTotal",
	    "count": 123,
	    "state": "succ"
	}*/
    @ApiOperation(value = "모든 사원의 수를 반환한다.", response = NumberResult.class)
	@RequestMapping(value = "/getEmployeesTotal", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> getEmployeesTotal() throws Exception {
		logger.info("1-------------findAllEmployees-----------------------------"+new Date());
		int total = employeeService.getEmployeesTotal();
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("getEmployeesTotal");
		nr.setState("succ");
		if (total<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
/*http://localhost:8199/humans/api/findAllDepartments2
   [
	    {
	        "department_id": 10,
	        "department_name": "Administration",
	        "manager_id": 0,
	        "location_id": 0
	    },*/
    @ApiOperation(value = "모든 부서의 정보를 반환한다. 사원이 없는 부서도 반환한다.", response = List.class)
	@RequestMapping(value = "/findAllDepartments2", method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentDto>> findAllDepartments2() throws Exception {
		logger.info("1-------------findAllDepartments2-----------------------------"+new Date());
		List<DepartmentDto> emps = employeeService.findAllDepartments2();
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DepartmentDto>>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findAllDepCounts
	[
	    {
	        "count": 45,
	        "department_id": 50,
	        "department_name": "Shipping"
	    },*/
    @ApiOperation(value = " 각 부서에 소속된 사원 수, 부서번호, 부서이름를 반환한다.", response = List.class)
	@RequestMapping(value = "/findAllDepCounts", method = RequestMethod.GET)
	public ResponseEntity<List<DepCountDto>> findAllDepCounts() throws Exception {
		logger.info("1-------------findAllDepCounts-----------------------------"+new Date());
		List<DepCountDto> emps = employeeService.findAllDepCounts();
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DepCountDto>>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findAllJobs
		[
		    "AD_PRES",
		    "AD_VP",
		    "AD_ASST",
		    "FI_MGR",
		    "FI_ACCOUNT",
		    "AC_MGR",
		    "AC_ACCOUNT",*/
    @ApiOperation(value = " 모든 직무를 반환한다.", response = List.class)
	@RequestMapping(value = "/findAllJobs", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllJobs() throws Exception {
		logger.info("1-------------findAllJobs-----------------------------"+new Date());
		List<String> emps = employeeService.findAllJobs();
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findEmployeesByManagerId/101
	[
	    {
	        "email": "NGREENBE",
	        "salary": 0,
	        "order2": null,
	        "firstName": "Nancy",
	        "phoneNumber": "515.124.4569",
	        "hireDate": "2002-08-17",
	        "jobId": null,
	        "employeeId": 108,
	        "lastName": "Greenberg",
	        "managerId": 101,
	        "commissionPct": 0,
	        "departmantId": 0
	    },*/
    @ApiOperation(value = " 해당 관리자에 대한 사원 관계를 트리로 반환한다.", response = List.class)
	@RequestMapping(value = "/findEmployeesByManagerId/{managerId}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDto>> findEmployeesByManagerId(@PathVariable String managerId) throws Exception {
		logger.info("1-------------findEmployeesByManagerId------------------------------------------------------"+new Date());
		logger.info("1-------------findEmployeesByManagerId-------------------------------------->>----------------"+managerId);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("managerId", managerId);
		List<EmployeeDto> emps = employeeService.findEmployeesByManagerId(map);
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findEmployeesByEmpId/101
	[
	    {
	        "email": "NKOCHHAR",
	        "salary": 0,
	        "order2": null,
	        "firstName": "Neena",
	        "phoneNumber": "515.123.4568",
	        "hireDate": "2005-09-21",
	        "jobId": null,
	        "employeeId": 101,
	        "lastName": "Kochhar",
	        "managerId": 0,
	        "commissionPct": 0,
	        "departmantId": 0
	    },*/
    @ApiOperation(value = "  해당 사원에 의해 관리되는 사원의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/findEmployeesByEmpId/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDto>> findEmployeesByEmpId(@PathVariable String employeeId) throws Exception {
		logger.info("1-------------findEmployeesByEmpId------------------------------------------------------"+new Date());
		logger.info("1-------------findEmployeesByEmpId-------------------------------------->>----------------"+employeeId);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("employeeId", employeeId);
		List<EmployeeDto> emps = employeeService.findEmployeesByEmpId(map);
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findEmployeeById/101
	{
	    "email": "NKOCHHAR",
	    "salary": 17000,
	    "order2": null,
	    "firstName": "Neena",
	    "phoneNumber": "515.123.4568",
	    "hireDate": "2005-09-21",
	    "jobId": "AD_VP",
	    "employeeId": 101,
	    "lastName": "Kochhar",
	    "managerId": 100,
	    "commissionPct": 0,
	    "departmantId": 90
	}*/
    @ApiOperation(value = "  해당 사원의 정보를 반환한다.", response = EmployeeDto.class)
	@RequestMapping(value = "/findEmployeeById/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable String employeeId) throws Exception {
		logger.info("1-------------findEmployeesByEmpId------------------------------------------------------"+new Date());
		logger.info("1-------------findEmployeesByEmpId-------------------------------------->>----------------"+employeeId);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("employeeId", employeeId);
		EmployeeDto emps = employeeService.findEmployeeById(map);
		if (emps==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EmployeeDto>(emps, HttpStatus.OK);
	}
/*	http://localhost:8199/humans/api/findManagersByName//king
		[
		    {
		        "email": "SKING",
		        "salary": 0,
		        "order2": null,
		        "firstName": "Steven",
		        "managerId": 0,
		        "hireDate": "2003-06-17",
		        "lastName": "King",
		        "employeeId": 100,
		        "jobId": null,
		        "phoneNumber": "515.123.4567",
		        "commissionPct": 0,
		        "departmantId": 0
		    },	*/
    @ApiOperation(value = " 이름으로(성 또는 이름) 사원의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/findManagersByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDto>> findManagersByName(@PathVariable String name) throws Exception {
		logger.info("1-------------findManagersByName------------------------------------------------------"+new Date());
		logger.info("1-------------findManagersByName-------------------------------------->>----------------"+name);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("lastName", __to(name).toUpperCase());
		map.put("firstName", __to(name).toUpperCase());
		List<EmployeeDto> emps = employeeService.findManagersByName(map);
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
/*	http://localhost:8199/humans/api/getTreeMaxLevel
	{
	    "name": "getTreeMaxLevel",
	    "count": 6,
	    "state": "succ"
	}*/
    @ApiOperation(value = " 관리자와 사원의 관계를 트리로 만들때 최대 leaf값을 반환한다.", response = NumberResult.class)
	@RequestMapping(value = "/getTreeMaxLevel", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> getTreeMaxLevel() throws Exception {
		logger.info("1-------------getTreeMaxLevel-----------------------------"+new Date());
		int total = employeeService.getTreeMaxLevel();
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("getTreeMaxLevel");
		nr.setState("succ");
		if (total<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
	
/*http://localhost:8199/humans/api/addEmployee
   {
        "email": "JalI",
        "salary": 3000,
        "order2": null,
        "firstName": "JJang",
        "managerId": 101,
        "hireDate": "2016-06-17",
        "lastName": "Kom",
        "employeeId": 0,
        "jobId": "AD_PRES",
        "phoneNumber": "123.456.678",
        "commissionPct": 0,
        "departmantId": 90
    }
    {
    "name": "addEmployee",
    "count": 357,
    "state": "succ"
}*/
	 
    @ApiOperation(value = " 새로운 사원을 정보를 입력한다. 그리고 그 사원의 사원번호를 반환한다.", response = NumberResult.class)
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> addEmployee(@RequestBody EmployeeDto dto) throws Exception {
		logger.info("1-------------addEmployee-----------------------------"+new Date());
		logger.info("1-------------addEmployee-----------------------------"+dto);
		int total = employeeService.addEmployee(dto);
		NumberResult nr=new NumberResult();
		nr.setCount(total);
		nr.setName("addEmployee");
		nr.setState("succ");
		logger.info("1-------------addEmployee-------employeeid------------------"+total);
		if (total<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
/*	
	http://localhost:8199/humans/api/updateEmployee
    {
        "email": "JalI",
        "salary": 3500,
        "order2": null,
        "firstName": "Jjangs",
        "managerId": 101,
        "hireDate": "2016-06-17",
        "lastName": "Komi",
        "employeeId": 357,
        "jobId": "AD_PRES",
        "phoneNumber": "123.456.678",
        "commissionPct": 0,
        "departmantId": 90
    }*/
    @ApiOperation(value = " 사원의 정보를 수정한다 만약 사원의 부서와 업무가 변경되면 잡히스토리에  자동(trigger)으로 추가된다. 원래 put이다.", response = BoolResult.class)
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> updateEmployee(@RequestBody EmployeeDto dto) throws Exception {
		logger.info("1-------------updateEmployee-----------------------------"+new Date());
		logger.info("1-------------updateEmployee-----------------------------"+dto);
		boolean total = employeeService.updateEmployee(dto);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("updateEmployee");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
/*	 실패 -> 원인을 찾자.
	 http://localhost:8199/humans/api/updateJobHistory
	  {
	    "employeeId": 357,
        "hireDate": "2016-08-20",
        "jobId": "IT_PROG",
        "departmantId": 60
    }*/
	   
    @ApiOperation(value = "  자동(trigger)으로 추가되기 때문에 사용되지 않는다. 원래 put이다.", response = BoolResult.class)
	@RequestMapping(value = "/updateJobHistory", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> updateJobHistory(@RequestBody EmployeeDto dto) throws Exception {
		logger.info("1-------------updateJobHistory-----------------------------"+new Date());
		logger.info("1-------------updateJobHistory-----------------------------"+dto);
		boolean total = employeeService.updateJobHistory(dto);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("updateJobHistory");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
/*	http://localhost:8199/humans/api/deleteEmployee/358
	{
    "name": "deleteEmployee",
    "count": true,
    "state": "true"
}*/
	 
    @ApiOperation(value = " 해당사원의 정보를 삭제한다. 사원의 정보를 삭제하기전, 정산하고 , 잡히스토리 수정등 여러 작업을 해야한다. 여기서는 히스토리를 모두 지우고(수정한 적이 없다면 바로 삭제가능) 삭제할 수 있다 . 원래 delete다", response = BoolResult.class)
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> deleteEmployee(@PathVariable String employeeId) throws Exception {
		logger.info("1-------------deleteEmployee-----------------------------"+new Date());
		logger.info("1-------------deleteEmployee-----------------------------"+employeeId);
		Map<String, String> map=new HashMap<String, String>();
		map.put("employeeId", employeeId);
		boolean total = employeeService.deleteEmployee(map);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("deleteEmployee");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	
}
