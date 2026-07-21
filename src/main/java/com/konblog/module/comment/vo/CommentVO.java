package com.konblog.module.comment.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CommentVO {
    private Long id;
    private String type;
    private Long articleId;
    private Long rootId;
    private String content;
    private Long toCommentUserId;
    private Long toCommentId;
    private Long createBy;
    private String createUserName;
    private String createUserAvatar;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") private LocalDateTime createTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Long getArticleId() { return articleId; }
    public void setArticleId(Long articleId) { this.articleId = articleId; }
    public Long getRootId() { return rootId; }
    public void setRootId(Long rootId) { this.rootId = rootId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Long getToCommentUserId() { return toCommentUserId; }
    public void setToCommentUserId(Long toCommentUserId) { this.toCommentUserId = toCommentUserId; }
    public Long getToCommentId() { return toCommentId; }
    public void setToCommentId(Long toCommentId) { this.toCommentId = toCommentId; }
    public Long getCreateBy() { return createBy; }
    public void setCreateBy(Long createBy) { this.createBy = createBy; }
    public String getCreateUserName() { return createUserName; }
    public void setCreateUserName(String createUserName) { this.createUserName = createUserName; }
    public String getCreateUserAvatar() { return createUserAvatar; }
    public void setCreateUserAvatar(String createUserAvatar) { this.createUserAvatar = createUserAvatar; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}