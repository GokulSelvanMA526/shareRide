
package com.copilot.syncroride.controller;

import com.copilot.syncroride.model.LoginRequest;
import com.copilot.syncroride.model.SignUpRequest;
import com.copilot.syncroride.serviceimpl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class is responsible for handling HTTP requests related to user operations such as registration and login.
// The class is annotated with @RestController, which indicates that it's a Spring MVC controller and
// its return values are directly written into the HTTP response body.
// The @RequestMapping("/syncroride/api/users") annotation is used to map web requests onto specific handler methods.
// In this case, all methods in this class will handle requests that start with /syncroride/api/users.
// The UserController class has two methods: signUp and login. Both methods are annotated with @PostMa
@RestController
@RequestMapping("/syncroride/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;

    //The signUp method takes a SignUpRequest object as a parameter.
    // This object is expected to be in the body of the HTTP request, as indicated by the @RequestBody annotation.
    // The @Valid annotation ensures that the SignUpRequest object is validated before the method is invoked.
    // If the validation fails, a method argument not valid exception is thrown.
    // The signUp method calls the addUser method of the UserServiceImpl service, passing the SignUpRequest object.
    // The return value is a message that is sent back to the client as the body of the HTTP response.
    // The ResponseEntity class is used to wrap the response message and set the HTTP status code.

    @PostMapping("/register")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        String message = userService.addUser(signUpRequest);
        log.info("Exit - signUp ");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


    // The login method takes a LoginRequest object as a parameter, validates it, and
    // passes it to the login method of the UserServiceImpl service.
    // The return value is a message that is sent back to the client as the body of the HTTP response.
    // The ResponseEntity class is used to wrap the response message and set the HTTP status code.
    // In this case, the status code is set to HttpStatus.OK, indicating that the request was successful.
    // The message is returned as the body of the response.
    // The @PostMapping("/login") annotation specifies that this method will handle POST requests to the /login endpoint.
    // The @RequestBody annotation indicates that the LoginRequest object will be passed in the request body.
    // The @Valid annotation ensures that the LoginRequest object is validated before the method is invoked.
    // If the validation fails, a method argument not valid exception is thrown.
    // The login method returns a ResponseEntity object with the response message and an HTTP status code.

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        String message = userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


}

