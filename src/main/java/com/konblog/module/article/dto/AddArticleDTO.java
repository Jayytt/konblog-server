package com.konblog.module.article.dto;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class AddArticleDTO {
    private Long id;
    @NotBlank(message = "title") private String title;
    private String content, summary, thumbnail, isTop, status, isComment;
    private Long categoryId;
    private List<Long> tagIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
    public String getIsTop() { return isTop; }
    public void setIsTop(String isTop) { this.isTop = isTop; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getIsComment() { return isComment; }
    public void setIsComment(String isComment) { this.isComment = isComment; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public List<Long> getTagIds() { return tagIds; }
    public void setTagIds(List<Long> tagIds) { this.tagIds = tagIds; }
}