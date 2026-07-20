package com.konblog.module.user.vo;
import lombok.Data;
@Data public class LoginVO {
    private String token; private Long userId; private String username; private String nickName; private String avatar;
}