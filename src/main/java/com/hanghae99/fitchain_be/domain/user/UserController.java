package com.hanghae99.fitchain_be.domain.user;

import com.hanghae99.fitchain_be.domain.user.dto.UserRequestDto;
import com.hanghae99.fitchain_be.grobal.exception.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<ResponseMessage<String>> signUp(@RequestBody UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
        return ResponseMessage.SuccessResponse("회원가입 성공!", "");
    }
}
