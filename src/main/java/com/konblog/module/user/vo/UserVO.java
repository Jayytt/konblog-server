package com.konblog.module.user.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data public class UserVO {
    private Long id; private String userName, nickName, email, phonenumber, sex, avatar, status;
    @JsonFormat(pattern=\