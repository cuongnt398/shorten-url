package com.example.shortenurl.common;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code;
    private String description;
    private T data;

    public BaseResponse(String code, String description, T data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }

    public BaseResponse(ResCode resCode, T data) {
        this(resCode.getCode(), resCode.getDescription(), data);
    }

    public BaseResponse(ResCode resCode) {
        this(resCode, null);
    }
    public BaseResponse(String code, String description) {
        this(code, description, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ResCode.SUCCESS, data);
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static <T> BaseResponse<T> internalError(T data) {
        return new BaseResponse<>(ResCode.INTERNAL_ERROR, data);
    }

    public static <T> BaseResponse<T> internalError() {
        return internalError(null);
    }
}
