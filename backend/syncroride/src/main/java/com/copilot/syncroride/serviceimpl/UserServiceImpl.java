package com.copilot.syncroride.serviceimpl;

import com.copilot.syncroride.entity.User;
import com.copilot.syncroride.model.LoginRequest;
import com.copilot.syncroride.model.SignUpRequest;
import com.copilot.syncroride.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * This service class contains methods of user service functionality like signUp, login and saving
 * user details.
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    /**
     * Handles user signup.
     *
     * @param signUpRequest the signup request containing user details
     * @return message containing user registration is success
     */

    public String addUser(SignUpRequest signUpRequest) {
        try {
            User user = new User();
            user.setName(signUpRequest.getName());
            user.setEmployeeId(signUpRequest.getEmployeeId());
            user.setPassword((signUpRequest.getPassword()));
            user.setPhoneNumber(signUpRequest.getMobileNumber());
            user.setGender(signUpRequest.getGender());
            userRepository.save(user);
            return "Successfully registered";
        } catch (DuplicateKeyException e) {
            // Handle duplicate key error
            return "A user with this ID already exists.";
        }
    }

    /**
     * Handles user login.
     *
     * @param loginRequest the login request containing email and password
     * @return a message containing user's login is success, or error message if login failed
     */

    public String login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmployeeId(loginRequest.getEmployeeId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return "LoggedIn Successfully";
        }
        return "User Details Does Not Exist";
    }


}
