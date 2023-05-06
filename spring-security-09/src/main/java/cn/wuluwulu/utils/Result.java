package cn.wuluwulu.utils;


import lombok.Data;

@Data
public class Result<T> {

    private Boolean success;
    private T data;
    private String message;

    public Result() {
    }

    public Result(Boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> ok(T data, String message) {
        return new Result<>(true, data, message);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(true, null, message);
    }
}
