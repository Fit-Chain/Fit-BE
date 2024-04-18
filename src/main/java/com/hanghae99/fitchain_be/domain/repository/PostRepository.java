package com.hanghae99.fitchain_be.domain.repository;

import com.hanghae99.fitchain_be.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
