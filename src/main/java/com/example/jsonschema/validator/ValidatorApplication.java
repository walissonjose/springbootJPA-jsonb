package com.example.jsonschema.validator;

import com.example.jsonschema.validator.configs.EnviromentVariablesListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidatorApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ValidatorApplication.class);
		application.addListeners(new EnviromentVariablesListener());
		application.run(args);
	}

}
