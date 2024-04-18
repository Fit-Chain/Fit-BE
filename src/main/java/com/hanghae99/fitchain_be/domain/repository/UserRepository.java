package com.hanghae99.fitchain_be.domain.repository;

import com.hanghae99.fitchain_be.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
