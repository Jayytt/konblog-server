package com.konblog.module.category.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sg_category")
public class Category implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String name, description, status, delFlag;
    private LocalDateTime createTime, updateTime;
    private Long createBy, updateBy;
}