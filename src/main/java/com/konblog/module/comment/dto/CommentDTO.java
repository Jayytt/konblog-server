package com.konblog.module.comment.dto;
import jakarta.validation.constraints.NotBlank;

public class CommentDTO {
    private Long articleId, rootId, toCommentUserId;
    @NotBlank(message = "content") private String content;

    public Long getArticleId() { return articleId; }
    public void setArticleId(Long articleId) { this.articleId = articleId; }
    public Long getRootId() { return rootId; }
    public void setRootId(Long rootId) { this.rootId = rootId; }
    public Long getToCommentUserId() { return toCommentUserId; }
    public void setToCommentUserId(Long toCommentUserId) { this.toCommentUserId = toCommentUserId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}