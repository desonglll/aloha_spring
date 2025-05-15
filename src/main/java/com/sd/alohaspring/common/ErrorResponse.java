package com.sd.alohaspring.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
