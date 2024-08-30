package ru.netology.springbootauthorization.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootauthorization.advice.InvalidCredentials;
import ru.netology.springbootauthorization.advice.UnauthorizedUser;
import ru.netology.springbootauthorization.domain.Authorities;
import ru.netology.springbootauthorization.model.Users;
import ru.netology.springbootauthorization.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/users")
    public List<Users> getAll() {
        return service.getAll();
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
