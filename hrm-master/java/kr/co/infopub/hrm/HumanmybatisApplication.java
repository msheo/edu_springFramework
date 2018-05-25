package kr.co.infopub.hrm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableTransactionManagement
public class HumanmybatisApplication {
    // 이것을 실행시키면 레스트풀 메인 시작
	public static void main(String[] args) {
		SpringApplication.run(HumanmybatisApplication.class, args);
	}
}
