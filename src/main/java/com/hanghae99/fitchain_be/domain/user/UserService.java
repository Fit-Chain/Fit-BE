package com.hanghae99.fitchain_be.domain.user;

import com.hanghae99.fitchain_be.domain.entity.User;
import com.hanghae99.fitchain_be.domain.repository.UserRepository;
import com.hanghae99.fitchain_be.domain.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserRequestDto userRequestDto) {
        User user = User.builder()
                .userName(userRequestDto.getUserName())
                .userId(userRequestDto.getUserId())
                .password(userRequestDto.getPassword())
                .nickName(userRequestDto.getNickName())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .email(userRequestDto.getEmail())
                .birth(userRequestDto.getBirth())
                .build();
        userRepository.save(user);
    }
}
