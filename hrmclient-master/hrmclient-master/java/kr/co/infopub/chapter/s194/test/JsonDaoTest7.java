package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import java.util.List;
import kr.co.infopub.chapter.s194.dto.DepCountDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest7 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 7) 			
		try {
			List<DepCountDto> femps=jdao.findAllDepCounts()  ;
			for(DepCountDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
