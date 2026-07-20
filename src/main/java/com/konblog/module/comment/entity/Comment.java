package com.konblog.module.comment.entity;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("sg_comment")
public class Comment implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String type, content;
    private Long articleId, rootId, toCommentUserId, toCommentId, createBy, updateBy;
    private LocalDateTime createTime, updateTime;
    @TableLogic private Integer delFlag;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Long getArticleId() { return articleId; }
    public void setArticleId(Long articleId) { this.articleId = articleId; }
    public Long getRootId() { return rootId; }
    public void setRootId(Long rootId) { this.rootId = rootId; }
    public Long getToCommentUserId() { return toCommentUserId; }
    public void setToCommentUserId(Long toCommentUserId) { this.toCommentUserId = toCommentUserId; }
    public Long getToCommentId() { return toCommentId; }
    public void setToCommentId(Long toCommentId) { this.toCommentId = toCommentId; }
    public Long getCreateBy() { return createBy; }
    public void setCreateBy(Long createBy) { this.createBy = createBy; }
    public Long getUpdateBy() { return updateBy; }
    public void setUpdateBy(Long updateBy) { this.updateBy = updateBy; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
    public Integer getDelFlag() { return delFlag; }
    public void setDelFlag(Integer delFlag) { this.delFlag = delFlag; }
}