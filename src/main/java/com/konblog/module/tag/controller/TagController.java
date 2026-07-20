package com.konblog.module.tag.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.tag.dto.TagDTO;
import com.konblog.module.tag.entity.Tag;
import com.konblog.module.tag.service.TagService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;
    public TagController(TagService tagService) { this.tagService = tagService; }
    @GetMapping("/user/list") public Result<List<Tag>> userList() { return Result.success(tagService.listAll()); }
    @GetMapping("/admin/list") @SaCheckRole("admin") public Result<List<Tag>> adminList() { return Result.success(tagService.listAll()); }
    @PostMapping("/admin") @SaCheckRole("admin") public Result<Long> create(@RequestBody TagDTO dto) { return Result.success(tagService.create(dto)); }
    @PutMapping("/admin") @SaCheckRole("admin") public Result<Void> update(@RequestBody TagDTO dto) { tagService.updateTag(dto); return Result.success(); }
    @DeleteMapping("/admin/{id}") @SaCheckRole("admin") public Result<Void> delete(@PathVariable Long id) { tagService.delete(id); return Result.success(); }
}