package com.hanghae99.fitchain_be.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @Size(min = 1, message = "아이디을 입력해주세요.")
    private String userId;
    @Size(min = 1, message = "비밀번호를 입력해주세요.")
    private String password;
}
