package com.konblog.module.user.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data public class LoginDTO { @NotBlank(message = "user") private String username; @NotBlank(message = "pwd") private String password; }