package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import java.util.List;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest {
 public static void main(String[] args) {
	EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
	// 1) 			
	try {
		List<EmployeeDto> femps = jdao.findAllEmployees();
		for(EmployeeDto femp: femps){
			System.out.println(femp);
		}
		System.out.println( "Size ------->"+femps.size());
	} catch (SQLException e) {
		System.out.println(e);
	}			
 }
}
