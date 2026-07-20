package com.konblog.common.exception;
import com.konblog.common.result.ErrorCode;
import lombok.Getter;
@Getter
public class BusinessException extends RuntimeException {
    private final int code;
    public BusinessException(ErrorCode ec) { super(ec.message); this.code = ec.code; }
}