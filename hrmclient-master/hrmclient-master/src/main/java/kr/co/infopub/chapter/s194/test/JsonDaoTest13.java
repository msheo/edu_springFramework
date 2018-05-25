package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest13 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 13) 			
		try {
			int count= jdao.getTreeMaxLevel();
			System.out.println( "getTreeMaxLevel ------->"+count);
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
