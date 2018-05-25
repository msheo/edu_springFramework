package kr.co.infopub.hrm;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class JsonServiceTest {
 @Autowired
 private TestRestTemplate restTemplate;
 @Test
 public void test() {
	ResponseEntity<List> res=
	this.restTemplate.getForEntity("/api/findAllEmployees", List.class);
	List<LinkedHashMap<String, Object>> usersMap =res.getBody();
	System.out.println(usersMap.get(0));
	Assert.assertEquals(usersMap.get(0).get("employeeId").toString(),"100");
	Assert.assertEquals(usersMap.get(0).get("firstName"),"Steven");
	Assert.assertEquals(usersMap.get(0).get("lastName"),"King");
	Assert.assertEquals(res.getStatusCode(), HttpStatus.OK);
 }
}