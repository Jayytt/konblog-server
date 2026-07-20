package com.konblog.module.category.dto;
import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {
    private Long id;
    @NotBlank(message = "name") private String name;
    private String description, status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}