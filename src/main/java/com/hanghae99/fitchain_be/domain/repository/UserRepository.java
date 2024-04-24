package com.hanghae99.fitchain_be.domain.repository;

import com.hanghae99.fitchain_be.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String userId);
}
