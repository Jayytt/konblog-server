package com.konblog.module.comment.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaCheckLogin;
import com.konblog.common.result.Result;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.service.CommentService;
import com.konblog.module.comment.vo.CommentVO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) { this.commentService = commentService; }

    @GetMapping("/user/article/{articleId}") public Result<List<CommentVO>> listByArticle(@PathVariable Long articleId) { return Result.success(commentService.listByArticle(articleId)); }
    @PostMapping("/user") @SaCheckLogin public Result<Long> create(@RequestBody CommentDTO dto) { return Result.success(commentService.create(dto)); }
    @GetMapping("/admin/list") @SaCheckRole("admin") public Result<List<CommentVO>> adminList() { return Result.success(commentService.listAll()); }
    @DeleteMapping("/admin/{id}") @SaCheckRole("admin") public Result<Void> delete(@PathVariable Long id) { commentService.delete(id); return Result.success(); }
}