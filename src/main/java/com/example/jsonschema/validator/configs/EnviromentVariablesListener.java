package com.example.jsonschema.validator.configs;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

public class EnviromentVariablesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        Environment env = event.getEnvironment();
        String variableName = "POSTGRES_HOST";
        String variableValue = env.getProperty(variableName);
        if (variableValue != null) {
            System.out.println("Conteúdo da variável " + variableName + " = " + variableValue);
        }
    }
}
