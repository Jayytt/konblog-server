package com.konblog.module.role.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.role.dto.RoleDTO;
import com.konblog.module.role.entity.Role;
import com.konblog.module.role.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@SaCheckRole("admin")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/admin/list")
    public Result<List<Role>> list() {
        return Result.success(roleService.listAll());
    }

    @PostMapping("/admin")
    public Result<Void> create(@RequestBody RoleDTO dto) {
        roleService.create(dto);
        return Result.success();
    }

    @PutMapping("/admin")
    public Result<Void> update(@RequestBody RoleDTO dto) {
        roleService.updateRole(dto);
        return Result.success();
    }

    @DeleteMapping("/admin/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return Result.success();
    }
}