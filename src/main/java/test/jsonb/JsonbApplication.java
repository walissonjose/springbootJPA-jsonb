package test.jsonb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JsonbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonbApplication.class, args);
	}

}
