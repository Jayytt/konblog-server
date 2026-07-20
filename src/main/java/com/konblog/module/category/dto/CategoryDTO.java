package com.konblog.module.category.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class CategoryDTO {
    private Long id; @NotBlank(message = "name") private String name; private String description, status;
}