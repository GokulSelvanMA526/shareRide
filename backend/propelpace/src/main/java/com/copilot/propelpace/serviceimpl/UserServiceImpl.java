package com.copilot.propelpace.serviceimpl;

import com.copilot.propelpace.entity.User;
import com.copilot.propelpace.model.LoginRequest;
import com.copilot.propelpace.model.SignUpRequest;
import com.copilot.propelpace.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
