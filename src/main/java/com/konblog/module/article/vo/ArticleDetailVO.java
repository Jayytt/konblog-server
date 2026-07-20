package com.konblog.module.article.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
@Data public class ArticleDetailVO {
    private Long id; private String title, content, summary, categoryName, thumbnail, isTop, status; private Long viewCount; private String isComment;
    @JsonFormat(pattern=\