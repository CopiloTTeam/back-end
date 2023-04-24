package com.pro4tech;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication()
public class App {
	public static void main(String[] args) {
		Map<String, Object> configuracao = new HashMap<>();
		configuracao.put("server.port", "8080");
		configuracao.put("spring.datasource.url", "jdbc:mysql://localhost:3306/pro4tech"); // rodar local
		configuracao.put("spring.datasource.username", "root"); // usuario
		configuracao.put("spring.datasource.password", "fatec"); // senha
		configuracao.put("spring.datasource.setMaxLifetime", "60"); // senha
		configuracao.put("spring.jpa.show-sql", "true"); // mostrar comandos
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update"); // criar editar

		SpringApplication app = new SpringApplication(App.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}
}
