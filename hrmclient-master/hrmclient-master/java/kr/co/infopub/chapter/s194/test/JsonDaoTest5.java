package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest5 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 5) 			
		try {
			int count= jdao.getEmployeesTotal();
			System.out.println( "getEmployeesTotal ---------------->"+count);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
