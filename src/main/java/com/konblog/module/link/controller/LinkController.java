package com.konblog.module.link.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.link.dto.LinkDTO;
import com.konblog.module.link.entity.Link;
import com.konblog.module.link.service.LinkService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final LinkService linkService;
    public LinkController(LinkService linkService) { this.linkService = linkService; }
    @GetMapping("/user/list") public Result<List<Link>> userList() { return Result.success(linkService.listAll()); }
    @GetMapping("/admin/list") @SaCheckRole("admin") public Result<List<Link>> adminList() { return Result.success(linkService.listAll()); }
    @PostMapping("/admin") @SaCheckRole("admin") public Result<Long> create(@RequestBody LinkDTO dto) { return Result.success(linkService.create(dto)); }
    @PutMapping("/admin") @SaCheckRole("admin") public Result<Void> update(@RequestBody LinkDTO dto) { linkService.update(dto); return Result.success(); }
    @DeleteMapping("/admin/{id}") @SaCheckRole("admin") public Result<Void> delete(@PathVariable Long id) { linkService.delete(id); return Result.success(); }
}