package com.konblog.module.menu.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.menu.entity.Menu;
import com.konblog.module.menu.service.MenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
@SaCheckRole("admin")
public class MenuController {
    private final MenuService menuService;
    public MenuController(MenuService menuService) { this.menuService = menuService; }
    @GetMapping("/admin/tree") public Result<List<Menu>> tree() { return Result.success(menuService.tree()); }
}