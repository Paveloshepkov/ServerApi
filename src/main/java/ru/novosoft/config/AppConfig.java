package ru.novosoft.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import ru.novosoft.controllers.AuthController;
import ru.novosoft.controllers.GetDataController;
import ru.novosoft.generators.Generator;
import ru.novosoft.repository.PeopleRepository;
import ru.novosoft.repository.PeopleRepositoryImpl;

@Configuration
@ComponentScan("ru.novosoft")
@EnableWebMvc
class AppConfig  {



	private final ApplicationContext applicationContext;

	@Autowired
	AppConfig(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public AppConfig() {
		this.applicationContext = null;
	}

	@Bean
	public AuthController authController() {
		return new AuthController();
	}

	@Bean
	public PeopleRepositoryImpl peopleRepository(Generator generator) {
		return new PeopleRepositoryImpl(generator);
	}

	@Bean
	public GetDataController getDataController() {
		return new GetDataController();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
		return objectMapper;
	}
}