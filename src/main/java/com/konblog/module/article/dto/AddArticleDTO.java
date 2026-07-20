package com.konblog.module.article.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;
@Data public class AddArticleDTO {
    private Long id;
    @NotBlank(message=\