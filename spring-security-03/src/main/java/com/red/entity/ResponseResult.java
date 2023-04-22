package com.red.entity;

import lombok.Data;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, T data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, data);
    }

    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<>(200, data, message);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<>(400, null, message);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return new ResponseResult<>(code, null, message);
    }


}
