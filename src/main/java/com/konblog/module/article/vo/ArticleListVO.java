package com.konblog.module.article.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class ArticleListVO {
    private Long id; private String title, summary, thumbnail, categoryName; private Long viewCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") private LocalDateTime createTime;
}