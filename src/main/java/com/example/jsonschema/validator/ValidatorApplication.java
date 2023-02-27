package com.example.jsonschema.validator;

import com.example.jsonschema.validator.configs.EnvironmentVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@ConfigurationPropertiesScan(basePackages = "com.example.jsonschema.validator.configs")
@SpringBootApplication
public class ValidatorApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ValidatorApplication.class);
		application.run(args);
	}

	@Autowired
	private EnvironmentVariables environmentVariables;
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationEvent() {

		System.out.println("Conteúdo da variável \n"+
				"POSTGRES_HOST: " + environmentVariables.getPostgresHost()+
				"\nPOSTGRES_DATABASE: " + environmentVariables.getPostgresDatabase()+
				"\nPOSTGRES_PASSWORD: " + environmentVariables.getPostgresPassword()+
				"\nPOSTGRES_PORT: " + environmentVariables.getPostgresPort() +
				""
		);

	}

}
