package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest11 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 11) 			
		try {
			EmployeeDto dto=jdao.findEmployeeById ("101");
			System.out.println( dto);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
