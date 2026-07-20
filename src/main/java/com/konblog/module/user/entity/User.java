package com.konblog.module.user.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String userName, password, nickName, email, phonenumber, sex, avatar, status, loginIp;
    private LocalDateTime loginDate, createTime, updateTime;
    private Long createBy, updateBy;
    @TableLogic private Integer delFlag;
}