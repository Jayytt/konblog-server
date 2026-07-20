package com.konblog.module.category.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class CategoryDTO {
    private Long id;
    @NotBlank(message=\