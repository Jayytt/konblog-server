package com.konblog.module.role.dto;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class RoleDTO {
    private Long id;
    @NotBlank(message = "name") private String name;
    @NotBlank(message = "key") private String roleKey;
    private String status;
    private List<Long> menuIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRoleKey() { return roleKey; }
    public void setRoleKey(String roleKey) { this.roleKey = roleKey; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Long> getMenuIds() { return menuIds; }
    public void setMenuIds(List<Long> menuIds) { this.menuIds = menuIds; }
}