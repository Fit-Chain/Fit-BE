package com.hanghae99.fitchain_be.domain.post.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostRequestDto {
    @Size(min = 1, message = "제목을 입력해주세요.")
    private String title;
    @Size(min = 1, message = "내용을 입력해주세요.")
    private String description;

}
