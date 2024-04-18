package com.hanghae99.fitchain_be.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @Size(min = 1, message = "이름을 입력해주세요.")
    private String userName;
    @Size(min = 1, message = "아이디을 입력해주세요.")
    private String userId;
    @Size(min = 1, message = "패스워드를 입력해주세요.")
    private String password;
    @Size(min = 1, message = "닉네임을 입력해주세요.")
    private String nickName;
    @Size(min = 1, message = "연락처를 입력해주세요.")
    private String phoneNumber;
    @Size(min = 1, message = "이메일을 입력해주세요.")
    private String email;
    @Size(min = 1, message = "생일을 입력해주세요.")
    private Date birth;
}
