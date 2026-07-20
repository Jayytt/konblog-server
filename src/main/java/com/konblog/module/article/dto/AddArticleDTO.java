package com.konblog.module.article.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class AddArticleDTO {
    private Long id;
    @NotBlank(message = "title") private String title;
    private String content, summary, thumbnail, isTop, status, isComment;
    private Long categoryId;
    private List<Long> tagIds;
}