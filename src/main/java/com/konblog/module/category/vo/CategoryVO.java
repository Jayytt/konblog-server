package com.konblog.module.category.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CategoryVO {
    private Long id; private String name, description, status; private Long articleCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") private LocalDateTime createTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getArticleCount() { return articleCount; }
    public void setArticleCount(Long articleCount) { this.articleCount = articleCount; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}