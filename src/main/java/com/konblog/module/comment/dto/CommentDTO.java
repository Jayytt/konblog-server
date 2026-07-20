package com.konblog.module.comment.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class CommentDTO {
    private Long articleId, rootId, toCommentUserId;
    @NotBlank(message=\