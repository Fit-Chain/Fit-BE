package com.hanghae99.fitchain_be.domain.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanghae99.fitchain_be.domain.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;

    private String title;

    private String description;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
    }


}