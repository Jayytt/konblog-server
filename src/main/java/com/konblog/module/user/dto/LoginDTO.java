package com.konblog.module.user.dto;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "user") private String username;
    @NotBlank(message = "pwd") private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}