package ru.novosoft.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.novosoft.generators.Generator;
import ru.novosoft.model.LoginRequest;
import ru.novosoft.model.MetrEquipItemModel;
import ru.novosoft.model.ResponseModel;
import ru.novosoft.model.Tasks;
import ru.novosoft.model.User;

@Controller
@RequestMapping("/api")
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private Generator generator;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> hello(@RequestBody LoginRequest loginRequest) {
		try {
			String login = loginRequest.getLogin();
			String password = loginRequest.getPassword();

			User foundUser = generator.findUser(login, password);
			if (foundUser != null) {
				List<Tasks> tasks = generator.getUserTasks(foundUser);
				List<MetrEquipItemModel> equipment = generator.getUserEquipment(foundUser);
				ResponseModel responseModel = new ResponseModel(tasks.stream()
						.map(task -> new Tasks(task.getId(), task.getType(), task.getTime()))
						.collect(Collectors.toList()));
				String tasksJson = objectMapper.writeValueAsString(responseModel);

				logger.info("Response message: {}", tasksJson);

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

				return new ResponseEntity<>(tasksJson, headers, HttpStatus.OK);
			} else {
				logger.info("No user found with provided credentials");
				return new ResponseEntity<>("No user found with provided credentials",
						HttpStatus.UNAUTHORIZED);
			}
		} catch (IOException e) {
			logger.error("Error processing request: {}", e.getMessage(), e);
			return new ResponseEntity<>("Error processing request",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	private String getRequestBody(HttpServletRequest request) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = request.getReader()) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append('\n');
			}
		} catch (IOException e) {
			logger.error("Error reading request body: {}", e.getMessage(), e);
		}
		return stringBuilder.toString();
	}

}


