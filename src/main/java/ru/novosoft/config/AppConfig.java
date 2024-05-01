package ru.novosoft.config;


import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.novosoft.controllers.ApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

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
	public ApiController apiController() {
		return new ApiController();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
		return objectMapper;
	}
}