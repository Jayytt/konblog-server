package com.konblog.module.link.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sg_link")
public class Link implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String name, logo, description, address, status;
    private LocalDateTime createTime, updateTime;
    private Long createBy, updateBy;
    @TableLogic private Integer delFlag;
}