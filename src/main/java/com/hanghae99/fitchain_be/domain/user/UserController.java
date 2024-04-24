package com.hanghae99.fitchain_be.domain.user;

import com.hanghae99.fitchain_be.domain.user.dto.LoginRequestDto;
import com.hanghae99.fitchain_be.domain.user.dto.UserRequestDto;
import com.hanghae99.fitchain_be.grobal.exception.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signUp")
    public ResponseEntity<ResponseMessage<String>> signUp(@Validated @RequestBody UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
        return ResponseMessage.SuccessResponse("회원가입 성공!", "");
    }
    @PostMapping("/signIn")
    public ResponseEntity<ResponseMessage<String>> signIn(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String accessToken = userService.signIn(loginRequestDto, response);
        return ResponseMessage.SuccessResponse("로그인 성공!", accessToken);
    }
}
