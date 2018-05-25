package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import java.util.List;
import kr.co.infopub.chapter.s194.dto.EmployeeDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest4 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 4) 			
		try {
			// IT, Shipping, Purchasing
			List<EmployeeDto> femps=jdao.findEmployeesByDepartName("Human Resources")  ;
			for(EmployeeDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size --------->"+femps.size());
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
