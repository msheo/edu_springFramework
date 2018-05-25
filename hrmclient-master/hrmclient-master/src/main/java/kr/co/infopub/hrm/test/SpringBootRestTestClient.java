package kr.co.infopub.hrm.test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
public class SpringBootRestTestClient {
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
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/findAllEmployees/", List.class);
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
            	System.out.println(dto);
            	lists.add(dto);
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
      
//    /* GET */
//    private static void getUser(){
//        System.out.println("Testing getUser API----------");
//        RestTemplate restTemplate = new RestTemplate();
//        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
//        System.out.println(user);
//    }
//      
//    /* POST */
//    private static void createUser() {
//        System.out.println("Testing create User API----------");
//        RestTemplate restTemplate = new RestTemplate();
//        User user = new User(0,"Sarah",51,134);
//        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
//        System.out.println("Location : "+uri.toASCIIString());
//    }
//  
//    /* PUT */
//    private static void updateUser() {
//        System.out.println("Testing update User API----------");
//        RestTemplate restTemplate = new RestTemplate();
//        User user  = new User(1,"Tomy",33, 70000);
//        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
//        System.out.println(user);
//    }
//  
//    /* DELETE */
//    private static void deleteUser() {
//        System.out.println("Testing delete User API----------");
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.delete(REST_SERVICE_URI+"/user/3");
//    }
//  
//  
//    /* DELETE */
//    private static void deleteAllUsers() {
//        System.out.println("Testing all delete Users API----------");
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.delete(REST_SERVICE_URI+"/user/");
//    }
  
    public static void main(String args[]){
        listAllUsers();
    }
}