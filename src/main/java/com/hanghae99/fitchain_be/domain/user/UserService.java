package com.hanghae99.fitchain_be.domain.user;

import com.hanghae99.fitchain_be.domain.entity.RefreshToken;
import com.hanghae99.fitchain_be.domain.entity.User;
import com.hanghae99.fitchain_be.domain.repository.RefreshTokenRepository;
import com.hanghae99.fitchain_be.domain.repository.UserRepository;
import com.hanghae99.fitchain_be.domain.user.dto.LoginRequestDto;
import com.hanghae99.fitchain_be.domain.user.dto.UserRequestDto;
import com.hanghae99.fitchain_be.grobal.exception.CustomErrorCode;
import com.hanghae99.fitchain_be.grobal.exception.CustomException;
import com.hanghae99.fitchain_be.grobal.jwt.JwtUtil;
import com.hanghae99.fitchain_be.grobal.jwt.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    public void signUp(UserRequestDto userRequestDto) {
        String newPw = passwordEncoder.encode(userRequestDto.getPassword());

        User user = User.builder()
                .userName(userRequestDto.getUserName())
                .userId(userRequestDto.getUserId())
                .password(newPw)
                .nickName(userRequestDto.getNickName())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .email(userRequestDto.getEmail())
                .birth(userRequestDto.getBirth())
                .build();
        userRepository.save(user);
    }

    public String signIn(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        User user = userRepository.findByUserId(loginRequestDto.getUserId()).orElseThrow(
                () -> new UsernameNotFoundException("사용자를 찾을 수 없습니다.")
        );
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new CustomException(CustomErrorCode.NOT_PROPER_ID_OR_PASSWORD);
        }
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByUserId(loginRequestDto.getUserId());

        TokenDto tokenDto = jwtUtil.createAllToken(loginRequestDto.getUserId());

        if(refreshToken.isPresent()) {
            refreshTokenRepository.save(refreshToken.get().updateToken(tokenDto.getRefreshToken()));
        }else {
            RefreshToken newRefreshToken = new RefreshToken(tokenDto.getRefreshToken(), loginRequestDto.getUserId());
            refreshTokenRepository.save(newRefreshToken);
        }
        setHeader(response, tokenDto);
        return tokenDto.getAccessToken();
    }

    private void setHeader(HttpServletResponse response, TokenDto tokenDto) {
        response.addHeader(JwtUtil.ACCESS_TOKEN, tokenDto.getAccessToken());
        response.addHeader(JwtUtil.REFRESH_TOKEN, tokenDto.getRefreshToken());
    }
}
