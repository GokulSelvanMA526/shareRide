package com.copilot.syncroride.serviceimpl;

import com.copilot.syncroride.entity.User;
import com.copilot.syncroride.model.LoginRequest;
import com.copilot.syncroride.model.SignUpRequest;
import com.copilot.syncroride.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addUser_returnsSuccessMessage() {
        SignUpRequest signUpRequest = new SignUpRequest();
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        String response = userService.addUser(signUpRequest);

        assertEquals("Successfully registered", response);
    }

    @Test
    public void login_returnsSuccessMessage() {
        LoginRequest loginRequest = new LoginRequest();
        User user = new User();
        user.setPassword("encodedPassword");
        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));

        String response = userService.login(loginRequest);

        assertEquals("LoggedIn Successfully", response);
    }

    @Test
    public void login_returnsErrorMessage() {
        LoginRequest loginRequest = new LoginRequest();
        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.empty());

        String response = userService.login(loginRequest);

        assertEquals("User Details Does Not Exist", response);
    }
}