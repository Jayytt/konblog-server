package com.konblog.common.exception;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.konblog.common.result.ErrorCode;
import com.konblog.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotLoginException.class) public Result<Void> n(NotLoginException e){return Result.fail(ErrorCode.UNAUTHORIZED);}
    @ExceptionHandler(NotPermissionException.class) public Result<Void> p(NotPermissionException e){return Result.fail(ErrorCode.FORBIDDEN);}
    @ExceptionHandler(MethodArgumentNotValidException.class) public Result<Void> v(MethodArgumentNotValidException e){return Result.fail(ErrorCode.BAD_REQUEST.code,e.getMessage());}
    @ExceptionHandler(BusinessException.class) public Result<Void> b(BusinessException e){return Result.fail(e.getCode(),e.getMessage());}
    @ExceptionHandler(Exception.class) public Result<Void> a(Exception e){log.error("err",e);return Result.fail(ErrorCode.INTERNAL_ERROR);}
}