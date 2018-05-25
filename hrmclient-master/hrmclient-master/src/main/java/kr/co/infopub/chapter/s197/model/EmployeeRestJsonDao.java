package kr.co.infopub.chapter.s197.model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;

import kr.co.infopub.chapter.s197.dto.DepCountDto;
import kr.co.infopub.chapter.s197.dto.DepartmentDto;
import kr.co.infopub.chapter.s197.dto.EmployeeDto;
import kr.co.infopub.chapter.s197.help.BoolResult;
import kr.co.infopub.chapter.s197.help.NumberResult;
public class EmployeeRestJsonDao {
	public static final String REST_SERVICE_URI = "http://localhost:8199/humans/api";
	public static int tI(Object obj){
    	if(obj==null){ return 0;
    	}else {
    		return Integer.parseInt(obj.toString());
    	}
    }
    public static double td(Object obj){
    	if(obj==null){ return 0.0;
    	}else {
    		return Double.parseDouble(obj.toString());
    	}
    }
    public static String ts(Object obj){
    	if(obj==null){ return "";
    	}else {
    		return (String)obj;
    	}
    }
    public static java.sql.Date tq(String obj){
    	if(obj==null || obj.equals("")){ 
    		return new java.sql.Date(new java.util.Date().getTime());
    	}else {
    		return java.sql.Date.valueOf(obj);
    	}
    }
    public static String to__(String v){
		return v.replaceAll(" ", "%20");
	}
    public static String __to(String v){
		return v.replaceAll("%20", " ");
	}
	public List<EmployeeDto> findAllEmployees() throws SQLException{
		System.out.println("Testing findAllEmployees API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI+"/findAllEmployees", List.class);
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	dto.setEmail(ts(map.get("email")));
            	dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	dto.setHireDate(tq(ts(map.get("hireDate"))));
            	dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findAllEmployees exist----------");
        }
        return lists;
	}
	
	public List<DepartmentDto> findAllDepartments () throws SQLException{
		System.out.println("Testing findAllDepartments API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI+"/findAllDepartments", List.class);
        List<DepartmentDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	DepartmentDto dto=new DepartmentDto();
            	dto.setDepartment_id(tI(map.get("department_id")));
            	dto.setDepartment_name(ts(map.get("department_name")));
            	dto.setManager_id(tI(map.get("manager_id")));
            	dto.setLocation_id(tI(map.get("location_id")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findAllDepartments exist----------");
        }
        return lists;
	}
	public  List<EmployeeDto> findTreeManagerInEmployee () throws SQLException{
		System.out.println("Testing findTreeManagerInEmployee API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/findTreeManagerInEmployee", List.class);
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	//dto.setEmail(ts(map.get("email")));
            	//dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	//dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	//dto.setHireDate(tq(ts(map.get("hireDate"))));
            	//dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	//dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	dto.setOrder2(ts(map.get("order2")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findTreeManagerInEmployee exist----------");
        }
        return lists;
	}
	public List<EmployeeDto> findEmployeesByDepartName(String department_name)throws SQLException{
		System.out.println("Testing findEmployeesByDepartName API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(
        		REST_SERVICE_URI+"/findEmployeesByDepartName/"+to__(department_name), List.class);
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	dto.setEmail(ts(map.get("email")));
            	dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	dto.setHireDate(tq(ts(map.get("hireDate"))));
            	dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findEmployeesByDepartName exist----------");
        }
        return lists;
	}
	public int getEmployeesTotal()throws SQLException{
		System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        NumberResult nresult = restTemplate.getForObject(REST_SERVICE_URI+"/getEmployeesTotal", NumberResult.class);
        if(nresult.getState().equals("succ")){
        	return nresult.getCount();
        }else{
        	return 0;
        }
	}
	public List<DepartmentDto> findAllDepartments2()throws SQLException{
		System.out.println("Testing findAllDepartments2 API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI+"/findAllDepartments2", List.class);
        List<DepartmentDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	DepartmentDto dto=new DepartmentDto();
            	dto.setDepartment_id(tI(map.get("department_id")));
            	dto.setDepartment_name(ts(map.get("department_name")));
            	dto.setManager_id(tI(map.get("manager_id")));
            	dto.setLocation_id(tI(map.get("location_id")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findAllDepartments2 exist----------");
        }
        return lists;
	}
	public List<DepCountDto> findAllDepCounts() throws SQLException{
		System.out.println("Testing findAllDepCounts API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI+"/findAllDepCounts", List.class);
        List<DepCountDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	DepCountDto dto=new DepCountDto();
            	dto.setDepartment_id(tI(map.get("department_id")));
            	dto.setDepartment_name(ts(map.get("department_name")));
            	dto.setCount(tI(map.get("count")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findAllDepCounts exist----------");
        }
        return lists;
	}
	public  List<String> findAllJobs ()throws SQLException{
		System.out.println("Testing findAllJobs API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<Object> usersMap = 
        		restTemplate.getForObject(REST_SERVICE_URI+"/findAllJobs", List.class);
        List<String> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(Object dto : usersMap){
                lists.add((String)dto);
            }
        }else{
            System.out.println("No findAllDepCounts exist----------");
        }
        return lists;
	}

	public  List<EmployeeDto> findEmployeesByManagerId (String managerId) throws SQLException{
		System.out.println("Testing findEmployeesByManagerId API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/findEmployeesByManagerId/"+managerId, List.class);
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	dto.setEmail(ts(map.get("email")));
            	dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	dto.setHireDate(tq(ts(map.get("hireDate"))));
            	dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	//System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No findEmployeesByManagerId exist----------");
        }
        return lists;
	}
	
	public  List<EmployeeDto> findEmployeesByEmpId (String employeeId) throws SQLException{
		System.out.println("Testing findEmployeesByEmpId API-----------");
		RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = null;
        try {
        	 usersMap=restTemplate.getForObject(REST_SERVICE_URI+"/findEmployeesByEmpId/"+employeeId, List.class);
		} catch (Exception e) {
			
		}
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	dto.setEmail(ts(map.get("email")));
            	dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	dto.setHireDate(tq(ts(map.get("hireDate"))));
            	dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	//dto.setOrder2(ts(map.get("order2")));
            	lists.add(dto);
            }
        }else{
            System.out.println("No findEmployeesByEmpId exist----------");
        }
        return lists;
	}
	public  EmployeeDto findEmployeeById (String employeeId)throws SQLException{
		System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        EmployeeDto nresult = restTemplate.getForObject(REST_SERVICE_URI+"/findEmployeeById/"+employeeId, EmployeeDto.class);
        return nresult;
	}
	
	public  List<EmployeeDto> findManagersByName(String name)throws SQLException{
		System.out.println("Testing findManagersByName API-----------");
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap=null;
		if(name==null || name.trim().equals("")){
			usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/findAllEmployees", List.class);
		}else{
			usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/findManagersByName/"+__to(name), List.class);
		}
        List<EmployeeDto> lists=new ArrayList<>();  
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
            	EmployeeDto dto=new EmployeeDto();
            	dto.setEmail(ts(map.get("email")));
            	dto.setSalary(td(map.get("salary")));
            	dto.setFirstName(ts(map.get("firstName")));
            	dto.setPhoneNumber(ts(map.get("phoneNumber")));
            	dto.setHireDate(tq(ts(map.get("hireDate"))));
            	dto.setJobId(ts(map.get("jobId")));
            	dto.setEmployeeId(tI(map.get("employeeId")));
            	dto.setLastName(ts(map.get("lastName")));
            	dto.setManagerId(tI(map.get("managerId")));
            	dto.setCommissionPct(td(map.get("commissionPct")));
            	dto.setDepartmantId(tI(map.get("departmantId")));
            	//dto.setOrder2(ts(map.get("order2")));
            	lists.add(dto);
            }
        }else{
            System.out.println("No findManagersByName exist----------");
        }
        return lists;
	}
	public int getTreeMaxLevel()throws SQLException{
		System.out.println("Testing getTreeMaxLevel API----------");
        RestTemplate restTemplate = new RestTemplate();
        NumberResult nresult = restTemplate.getForObject(REST_SERVICE_URI+"/getTreeMaxLevel", NumberResult.class);
        if(nresult.getState().equals("succ")){
        	return nresult.getCount();
        }else{
        	return 0;
        }
	}
	
	public  int addEmployee (EmployeeDto emp)throws SQLException{
		System.out.println("Testing addEmployee  API----------");
        RestTemplate restTemplate = new RestTemplate();
        NumberResult nresult = restTemplate.postForObject(REST_SERVICE_URI+"/addEmployee", emp, NumberResult.class);
        //System.out.println("Location : "+uri.toASCIIString());
        if(nresult.getState().equals("succ")){
        	return nresult.getCount();
        }else{
        	return 0;
        }
	}
	//put???
	public  boolean updateEmployee(EmployeeDto emp)throws SQLException{
		System.out.println("Testing updateEmployee  API----------");
        RestTemplate restTemplate = new RestTemplate();
        BoolResult nresult = restTemplate.postForObject(REST_SERVICE_URI+"/updateEmployee", emp, BoolResult.class);
        //System.out.println("Location : "+uri.toASCIIString());
        if(nresult.getState().equals("succ")){
        	return nresult.isCount();
        }else{
        	return false;
        }
	}
	public  boolean updateJobHistory(EmployeeDto emp)throws SQLException{
		System.out.println("Testing updateJobHistory  API----------");
        RestTemplate restTemplate = new RestTemplate();
        
        BoolResult nresult = restTemplate.postForObject(REST_SERVICE_URI+"/updateJobHistory", emp, BoolResult.class);
        //System.out.println("Location : "+uri.toASCIIString());
        if(nresult.getState().equals("succ")){
        	return nresult.isCount();
        }else{
        	return false;
        }
	}
	
	public  boolean deleteEmployee(EmployeeDto emp)throws SQLException{
		System.out.println("Testing deleteEmployee  API----------");
/*      RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/deleteEmployee/"+employeeId);
        return true;*/
		RestTemplate restTemplate = new RestTemplate();
        BoolResult nresult = restTemplate.postForObject(REST_SERVICE_URI+"/deleteEmployee/"+emp.getEmployeeId(), null  ,BoolResult.class);
        //System.out.println("Location : "+uri.toASCIIString());
        if(nresult.getState().equals("succ")){
        	return nresult.isCount();
        }else{
        	return false;
        }
	}
	
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		try {
			// 1) findAllEmployees
			List<EmployeeDto> femps=jdao.findAllEmployees()  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());
			// 2) findAllDepartments
/*			List<DepartmentDto> femps=jdao.findAllDepartments()  ;
			for(DepartmentDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			// 3) findTreeManagerInEmployee
/*			List<EmployeeDto> femps=jdao.findTreeManagerInEmployee()  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp.getOrder2());
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			// 4) findEmployeesByDepartName/Human Resources
/*			List<EmployeeDto> femps=jdao.findEmployeesByDepartName("Human Resources")  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());
*/			
			// 5) getEmployeesTotal
/*			int count= jdao.getEmployeesTotal();
			System.out.println( "getEmployeesTotal ---------------->"+count);*/
			// 6) findAllDepartments2
/*			List<DepartmentDto> femps=jdao.findAllDepartments2()  ;
			for(DepartmentDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			
			// 7) findAllDepCounts
/*			List<DepCountDto> femps=jdao.findAllDepCounts()  ;
			for(DepCountDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			
			// 8) findAllJobs
/*			List<String> femps=jdao.findAllJobs ();
			for(String femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/			
			// 9) findEmployeesByManagerId/100
/*			List<EmployeeDto> femps=jdao.findEmployeesByManagerId("100")  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			
			// 10) List<EmployeeDto> findEmployeesByEmpId (String employeeId)
/*			List<EmployeeDto> femps=jdao.findEmployeesByEmpId("101")  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			
			// 11) EmployeeDto findEmployeeById (String employeeId)
/*			EmployeeDto dto=jdao.findEmployeeById ("101");
			System.out.println( dto);*/
			
			// 12) findManagersByName(String name)
/*			List<EmployeeDto> femps=jdao.findManagersByName("king")  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());*/
			
			// 13) int getTreeMaxLevel ()
/*			int count= jdao.getTreeMaxLevel();
			System.out.println( "getTreeMaxLevel ---------------->"+count);*/
			
			// 14) int addEmployee (EmployeeDto emp)
/*			EmployeeDto dto=new EmployeeDto();
			dto.setCommissionPct(0.0);
			dto.setDepartmantId(60);
			dto.setEmail("Jongu");
			dto.setFirstName("Jongu");
			dto.setLastName("Lee");
			dto.setHireDate(java.sql.Date.valueOf("2016-05-04"));
			dto.setJobId("AD_PRES");
			dto.setManagerId(101);
			dto.setSalary(3456.78);
			dto.setPhoneNumber("010.6789.7890");
			int count= jdao.addEmployee(dto);
			System.out.println( "addEmployee ---------------->"+count);*/
			
			// 15) 
/*			EmployeeDto dto=new EmployeeDto();
			dto.setEmployeeId(361);
			dto.setCommissionPct(0.0);
			dto.setDepartmantId(70);
			dto.setEmail("Jongu");
			dto.setFirstName("Jongu");
			dto.setLastName("Lee");
			dto.setHireDate(java.sql.Date.valueOf("2016-05-04"));
			dto.setJobId("SA_MAN");
			dto.setManagerId(204);
			dto.setSalary(3456.78);
			dto.setPhoneNumber("010.6789.7890");
			boolean count= jdao.updateEmployee(dto);
			System.out.println( "updateEmployee ---------------->"+count);*/
			
			// 16) delete  
/*			boolean count= jdao.deleteEmployee("360");
			System.out.println( "deleteEmployee ---------------->"+count);*/
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
}
