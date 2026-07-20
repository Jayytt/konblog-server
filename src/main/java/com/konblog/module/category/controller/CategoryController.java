package com.konblog.module.category.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.category.dto.CategoryDTO;
import com.konblog.module.category.service.CategoryService;
import com.konblog.module.category.vo.CategoryVO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }
    @GetMapping("/user/list") public Result<List<CategoryVO>> userList() { return Result.success(categoryService.listAll()); }
    @GetMapping("/admin/list") @SaCheckRole("admin") public Result<List<CategoryVO>> adminList() { return Result.success(categoryService.listAll()); }
    @PostMapping("/admin") @SaCheckRole("admin") public Result<Long> create(@RequestBody CategoryDTO dto) { return Result.success(categoryService.create(dto)); }
    @PutMapping("/admin") @SaCheckRole("admin") public Result<Void> update(@RequestBody CategoryDTO dto) { categoryService.updateCategory(dto); return Result.success(); }
    @DeleteMapping("/admin/{id}") @SaCheckRole("admin") public Result<Void> delete(@PathVariable Long id) { categoryService.delete(id); return Result.success(); }
}