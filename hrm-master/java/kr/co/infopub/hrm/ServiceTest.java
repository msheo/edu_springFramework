package kr.co.infopub.hrm;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import kr.co.infopub.hrm.dto.EmployeeDto;
import kr.co.infopub.hrm.service.EmployeeService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ServiceTest {
 @Autowired
 private EmployeeService service;
 @Test
 public void test() {   
    try {
		List<EmployeeDto> lists=service.findAllEmployees();
		Assert.assertEquals(127, lists.size());  // 사원수를 변경하세요
		Assert.assertEquals(100, lists.get(0).getEmployeeId());
		Assert.assertEquals("Steven", lists.get(0).getFirstName());
		Assert.assertEquals("King", lists.get(0).getLastName());
	} catch (Exception e) {
	}
 }
}