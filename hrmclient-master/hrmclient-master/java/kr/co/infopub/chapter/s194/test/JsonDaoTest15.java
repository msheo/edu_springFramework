package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest15 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 15) 14)에 대하여 수정하세요			
		try {
			EmployeeDto dto=new EmployeeDto();
			dto.setEmployeeId(364);
			dto.setCommissionPct(0.0);
			dto.setDepartmantId(60);
			dto.setEmail("Clark");
			dto.setFirstName("Clark");
			dto.setLastName("Jhon");
			dto.setHireDate(java.sql.Date.valueOf("2016-05-09"));
			dto.setJobId("AD_PRES");
			dto.setManagerId(101);
			dto.setSalary(3456.78);
			dto.setPhoneNumber("010.6789.7892");
			boolean count= jdao.updateEmployee(dto);
			System.out.println( "updateEmployee ---------------->"+count);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
