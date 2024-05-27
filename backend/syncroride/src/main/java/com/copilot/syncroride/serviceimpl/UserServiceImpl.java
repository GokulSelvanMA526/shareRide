package com.copilot.syncroride.serviceimpl;

import com.copilot.syncroride.entity.User;
import com.copilot.syncroride.model.LoginRequest;
import com.copilot.syncroride.model.SignUpRequest;
import com.copilot.syncroride.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This service class contains methods of user service functionality like signUp, login and saving
 * user details.
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Handles user login.
     *
     * @param loginRequest the login request containing email and password
     * @return a message containing user's login is success, or error message if login failed
     */

    public String login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return "LoggedIn Successfully";
            }
        }
        return "User Details Does Not Exist";
    }


    /**
     * Handles user signup.
     *
     * @param signUpRequest the signup request containing user details
     * @return message containing user registration is success
     */

    public String addUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setGender(signUpRequest.getGender());
        userRepository.save(user);
        return "Successfully registered";
    }
}
