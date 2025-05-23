package com.sd.aloha_spring.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    Integer code;
    String message;
    String detail;

    public static ErrorResponse error(int code, String message, String detail) {
        return new ErrorResponse(code, message, detail);
    }
}
