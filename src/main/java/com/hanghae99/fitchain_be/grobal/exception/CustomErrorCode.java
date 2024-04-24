package com.hanghae99.fitchain_be.grobal.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_PASSWORD(BAD_REQUEST,"비밀번호가 유효하지 않습니다"),
    DUPLICATE_EMAIL(BAD_REQUEST, "중복된 이메일이 존재합니다"),
    DUPLICATE_NICKNAME(BAD_REQUEST, "중복된 닉네임이 존재합니다"),
    DUPLICATE_PHONENUMBER(BAD_REQUEST, "중복된 번호가 존재합니다"),
    DUPLICATE_PASSWORD(BAD_REQUEST, "현재 비밀번호로 변경이 불가능합니다"),
    NOT_PROPER_ID_OR_PASSWORD(BAD_REQUEST, "아이디 또는 비밀번호가 일치하지 않습니다."),
    NOT_PROPER_INPUTFORM(BAD_REQUEST, "입력한 형식이 맞지 않습니다."),
    NOT_PROPER_URLFORM(BAD_REQUEST, "입력한 URL 형식이 맞지 않습니다."),
    NOT_AUTHOR(BAD_REQUEST, "작성자만 삭제/수정할 수 있습니다."),
    TITLE_IS_EMPTY(BAD_REQUEST, "제목에 빈 값이 올 수 없습니다"),   //캘린더, 게시글 테이블
    CONTENT_IS_EMPTY(BAD_REQUEST, "내용에 빈 값이 올 수 없습니다"), //캘린더, 게시글, 댓글 테이블
    DATE_IS_EMPTY(BAD_REQUEST, "날짜를 선택해주세요"),
    FALSE_ID(BAD_REQUEST, "잘못된 ID입니다"),





    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    POST_NOT_FOUND(NOT_FOUND, "선택한 게시물을 찾을 수 없습니다."),
    USER_NOT_FOUND(NOT_FOUND, "사용자를 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(NOT_FOUND, "선택한 댓글을 찾을 수 없습니다."),
    CALENDAR_DTO_NOT_FOUND(NOT_FOUND,"저장할 정보가 없습니다.");



    private final HttpStatus httpStatus;
    private final String message;
}
