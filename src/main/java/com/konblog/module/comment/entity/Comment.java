package com.konblog.module.comment.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sg_comment")
public class Comment implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String type, content;
    private Long articleId, rootId, toCommentUserId, toCommentId, createBy, updateBy;
    private LocalDateTime createTime, updateTime;
    @TableLogic private Integer delFlag;
}