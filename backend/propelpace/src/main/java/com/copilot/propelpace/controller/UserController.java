
package com.copilot.propelpace.controller;

import com.copilot.propelpace.model.LoginRequest;
import com.copilot.propelpace.model.SignUpRequest;
import com.copilot.propelpace.serviceimpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

/**
     * This method is used to register a new user.
     *
     * @param signURequest
     * @return
     */
    @Autowired
UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<String> signUp( @RequestBody SignUpRequest signUpRequest) {
        String message = userService.addUser(signUpRequest);
        log.info("Exit - signUp ");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String message = userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


}

