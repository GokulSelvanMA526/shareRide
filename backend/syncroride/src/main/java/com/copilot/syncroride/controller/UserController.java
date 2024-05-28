
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

@RestController
@RequestMapping("/syncroride/api/users")
@RequiredArgsConstructor
@Validated
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
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        String message = userService.addUser(signUpRequest);
        log.info("Exit - signUp ");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        String message = userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


}

