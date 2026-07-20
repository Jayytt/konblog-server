package com.konblog.common.result;
import lombok.Data;
@Data
public class Result<T> {
    private int code; private String message; private T data;
    public static <T> Result<T> success(T d) { Result<T> r = new Result<>(); r.code=200; r.message="OK"; r.data=d; return r; }
    public static <T> Result<T> success() { return success(null); }
    public static <T> Result<T> fail(int c, String m) { Result<T> r = new Result<>(); r.code=c; r.message=m; return r; }
    public static <T> Result<T> fail(ErrorCode ec) { return fail(ec.code, ec.message); }
}