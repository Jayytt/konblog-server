package com.konblog.common.exception;
import com.konblog.common.result.ErrorCode;

public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(ErrorCode ec) { super(ec.message); this.code = ec.code; }

    public int getCode() { return code; }
}