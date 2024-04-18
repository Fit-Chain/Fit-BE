package com.hanghae99.fitchain_be.domain.post;

import com.hanghae99.fitchain_be.domain.entity.Post;
import com.hanghae99.fitchain_be.domain.post.dto.PostRequestDto;
import com.hanghae99.fitchain_be.domain.post.dto.PostResponseDto;
import com.hanghae99.fitchain_be.domain.repository.PostRepository;
import com.hanghae99.fitchain_be.grobal.exception.CustomErrorCode;
import com.hanghae99.fitchain_be.grobal.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
//spring.datasource.url=jdbc:mysql://localhost:3306/스키마명?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
    }


    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(CustomErrorCode.POST_NOT_FOUND));
        return new PostResponseDto(post);
    }

    public String updatePost(Long postId, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.update(postRequestDto);
        return "업데이트 성공";
    }


    public String deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.delete(post);
        return "삭제 성공";
    }
}
