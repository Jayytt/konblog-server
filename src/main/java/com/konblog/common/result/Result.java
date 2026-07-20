package com.konblog.common.result;
import lombok.Data;
@Data
public class Result<T> {
    private int code; private String message; private T data;
    public static <T> Result<T> success(T d) { Result<T> r = new Result<>(); r.code=200; r.message=\