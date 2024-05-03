package ru.novosoft.controllers;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.novosoft.generators.Generator;
import ru.novosoft.model.*;
import ru.novosoft.config.JWTFilter;
import ru.novosoft.security.JWTUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/get")
public class GetDataController {

    private static final Logger logger = LoggerFactory.getLogger(GetDataController.class);

    @Autowired
    private Generator generator;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JWTFilter jwtFilter;

    @Autowired
    JWTUtil jwtUtil;


    @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTasks(HttpServletRequest request) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>("Invalid JWT Token in Bearer Header", HttpStatus.BAD_REQUEST);
        }

        String jwt = token.substring(7).trim();

        try {
            String username = jwtUtil.validateTokenAndRetrieveClaim(jwt);

            // Проверяем существует ли пользователь с таким именем
            Person person = generator.loadUserByUsername(username);

            // Если пользователь не найден, возвращаем ошибку
            if (person == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            List<Tasks> tasks = generator.getUserTasks(person);

            ResponseTaskModel responseTaskModel = new ResponseTaskModel(tasks);

            String json = objectMapper.writeValueAsString(responseTaskModel);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

            return new ResponseEntity<>(json, headers, HttpStatus.OK);
        } catch (JWTVerificationException e) {
            return new ResponseEntity<>("Invalid JWT Token", HttpStatus.UNAUTHORIZED);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Failed to convert tasks to JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(value = "/equipment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEquipment(HttpServletRequest request) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>("Invalid JWT Token in Bearer Header", HttpStatus.BAD_REQUEST);
        }

        String jwt = token.substring(7).trim();

        try {
            String username = jwtUtil.validateTokenAndRetrieveClaim(jwt);

            // Проверяем существует ли пользователь с таким именем
            Person person = generator.loadUserByUsername(username);

            // Если пользователь не найден, возвращаем ошибку
            if (person == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            List<MetrEquipItemModel> equipment = generator.getUserEquipment(person);

            ResponseEquipmentModel responseEquipmentModel = new ResponseEquipmentModel(equipment);

            String json = objectMapper.writeValueAsString(responseEquipmentModel);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

            return new ResponseEntity<>(json, headers, HttpStatus.OK);
        } catch (JWTVerificationException e) {
            return new ResponseEntity<>("Invalid JWT Token", HttpStatus.UNAUTHORIZED);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Failed to convert tasks to JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
