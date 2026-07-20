package com.konblog.module.user.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;
@Data public class UserDTO {
    private Long id; @NotBlank(message = "user") private String userName;
    private String nickName, password, email, phonenumber, sex, avatar, status; private List<Long> roleIds;
}