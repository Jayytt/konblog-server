package com.konblog.module.link.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class LinkDTO {
    private Long id; @NotBlank(message = "name") private String name; private String logo, description;
    @NotBlank(message = "addr") private String address; private String status;
}