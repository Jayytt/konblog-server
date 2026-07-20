package com.konblog.module.tag.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class TagDTO {
    private Long id;
    @NotBlank(message=\