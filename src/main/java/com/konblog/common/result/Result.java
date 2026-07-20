package com.konblog.common.result;

public class Result<T> {
    private int code; private String message; private T data;

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public static <T> Result<T> success(T d) { Result<T> r = new Result<>(); r.code=200; r.message="OK"; r.data=d; return r; }
    public static <T> Result<T> success() { return success(null); }
    public static <T> Result<T> fail(int c, String m) { Result<T> r = new Result<>(); r.code=c; r.message=m; return r; }
    public static <T> Result<T> fail(ErrorCode ec) { return fail(ec.code, ec.message); }
}