package com.konblog.module.tag.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sg_tag")
public class Tag implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String name, status;
    private LocalDateTime createTime, updateTime;
    private Long createBy, updateBy;
    @TableLogic private Integer delFlag;
}