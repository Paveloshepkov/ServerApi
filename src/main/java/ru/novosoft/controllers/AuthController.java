package ru.novosoft.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.novosoft.generators.Generator;
import ru.novosoft.model.*;
import ru.novosoft.security.JWTUtil;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private Generator generator;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest) {
		String login = loginRequest.getLogin();
		String password = loginRequest.getPassword();

		Person foundPerson = generator.findUser(login, password);
		if (foundPerson != null) {
			String token = jwtUtil.generateToken(foundPerson.getUsername());
			LoginResponse loginResponse = new LoginResponse(token);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(loginResponse, headers, HttpStatus.OK);
		} else {

			return new ResponseEntity<>("No user found with provided credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/check/connection", method = RequestMethod.GET)
	public ResponseEntity<?> sayHi() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(true, headers, HttpStatus.OK);
	}
}


