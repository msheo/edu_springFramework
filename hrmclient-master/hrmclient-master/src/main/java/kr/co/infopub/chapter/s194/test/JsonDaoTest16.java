package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest16 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 16) 15) 수정을 했다면 delete 못할 수도 - job_history  	
		// 14)하고 16)하면 제거가능
		try {
			EmployeeDto dto=new EmployeeDto();
			dto.setEmployeeId(365);
			boolean count= jdao.deleteEmployee(dto);
			System.out.println( "deleteEmployee ---------------->"+count);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
