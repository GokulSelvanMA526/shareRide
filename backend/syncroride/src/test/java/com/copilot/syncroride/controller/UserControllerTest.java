package com.copilot.syncroride.controller;

import com.copilot.syncroride.model.LoginRequest;
import com.copilot.syncroride.model.SignUpRequest;
import com.copilot.syncroride.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void signUp_returnsSuccessMessage() {
        SignUpRequest signUpRequest = new SignUpRequest();
        String message = "User registered successfully";
        when(userService.addUser(signUpRequest)).thenReturn(message);

        ResponseEntity<String> response = userController.signUp(signUpRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void signUp_returnsErrorMessage() {
        SignUpRequest signUpRequest = new SignUpRequest();
        String message = "Error registering user";
        when(userService.addUser(signUpRequest)).thenReturn(message);

        ResponseEntity<String> response = userController.signUp(signUpRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void login_returnsSuccessMessage() {
        LoginRequest loginRequest = new LoginRequest();
        String message = "User logged in successfully";
        when(userService.login(loginRequest)).thenReturn(message);

        ResponseEntity<String> response = userController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void login_returnsErrorMessage() {
        LoginRequest loginRequest = new LoginRequest();
        String message = "Error logging in user";
        when(userService.login(loginRequest)).thenReturn(message);

        ResponseEntity<String> response = userController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }
}