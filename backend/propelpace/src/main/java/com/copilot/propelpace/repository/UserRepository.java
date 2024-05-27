package com.copilot.propelpace.repository;


import com.copilot.propelpace.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface for User entity.
 * This repository class contains queries to access  details.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
