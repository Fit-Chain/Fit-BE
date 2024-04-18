package com.hanghae99.fitchain_be.domain.post.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostRequestDto {

    private String title;
    private String description;

}
