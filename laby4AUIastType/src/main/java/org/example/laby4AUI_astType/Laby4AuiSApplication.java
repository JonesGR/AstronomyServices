package org.example.laby4AUI_astType ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Laby4AuiSApplication {

	public static void main(String[] args) {

		SpringApplication.run(Laby4AuiSApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(@Value("${ast.celestial.url}") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}

}
