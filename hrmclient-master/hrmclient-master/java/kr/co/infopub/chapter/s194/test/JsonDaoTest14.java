package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest14 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 14) 없는 사원을 입력하세요.			
		try {
			EmployeeDto dto=new EmployeeDto();
			dto.setCommissionPct(0.0);
			dto.setDepartmantId(60);
			dto.setEmail("Clarks");
			dto.setFirstName("Clarks");
			dto.setLastName("Jhon");
			dto.setHireDate(java.sql.Date.valueOf("2016-05-10"));
			dto.setJobId("AD_PRES");
			dto.setManagerId(101);
			dto.setSalary(3456.78);
			dto.setPhoneNumber("010.6789.7891");
			int count= jdao.addEmployee(dto);
			System.out.println( "addEmployee ---------------->"+count);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
