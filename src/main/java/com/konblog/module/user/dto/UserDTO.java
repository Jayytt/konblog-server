package com.konblog.module.user.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;
@Data public class UserDTO {
    private Long id;
    @NotBlank(message=\