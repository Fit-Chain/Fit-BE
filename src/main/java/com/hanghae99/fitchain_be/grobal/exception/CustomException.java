package com.hanghae99.fitchain_be.grobal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final CustomErrorCode errorCode;

}
