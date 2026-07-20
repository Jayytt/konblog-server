package com.konblog.module.article.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sg_article")
public class Article implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String title, content, summary, thumbnail, isTop, status, isComment;
    private Long categoryId, viewCount, createBy, updateBy;
    private LocalDateTime createTime, updateTime;
    @TableLogic private Integer delFlag;
}