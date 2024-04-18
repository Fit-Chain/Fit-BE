package com.hanghae99.fitchain_be.domain.post;

import com.hanghae99.fitchain_be.domain.post.dto.PostRequestDto;
import com.hanghae99.fitchain_be.domain.post.dto.PostResponseDto;
import com.hanghae99.fitchain_be.grobal.exception.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<ResponseMessage<String>> createPost(@Validated @RequestBody PostRequestDto postRequestDto) throws IOException {
        postService.createPost(postRequestDto);
        return  ResponseMessage.SuccessResponse("게시물 작성 성공","");
    }

    @GetMapping("/posts/postId")
    public ResponseEntity<ResponseMessage<PostResponseDto>> getPost(Long postId) throws IOException {
        return ResponseMessage.SuccessResponse("게시물 조회 성공",postService.getPost(postId));
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<ResponseMessage<String>> updatePost(@PathVariable Long postId, PostRequestDto postRequestDto) throws IOException {
        return  ResponseMessage.SuccessResponse("게시글 업데이트 성공",postService.updatePost(postId, postRequestDto));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ResponseMessage<String>> deletePost(Long postId) throws IOException{
        return ResponseMessage.SuccessResponse("게시글 삭제 성공", postService.deletePost(postId));
    }

}
