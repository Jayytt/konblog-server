package com.konblog.common.result;
public enum ErrorCode {
    BAD_REQUEST(400,"bad"),UNAUTHORIZED(401,"unauth"),FORBIDDEN(403,"forbid"),
    NOT_FOUND(404,"not found"),INTERNAL_ERROR(500,"server"),
    USER_NOT_FOUND(1001,"no user"),PASSWORD_ERROR(1002,"pwd");
    public final int code; public final String message;
    ErrorCode(int c,String m){this.code=c;this.message=m;}
}