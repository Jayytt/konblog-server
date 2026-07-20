package com.konblog.module.role.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_role")
public class Role implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String name, roleKey, status, delFlag;
    private LocalDateTime createTime, updateTime;
    private Long createBy, updateBy;
}