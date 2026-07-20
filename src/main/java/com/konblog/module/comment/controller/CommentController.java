package com.konblog.module.comment.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaCheckLogin;
import com.konblog.common.result.Result;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import com.konblog.module.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/user/article/{articleId}")
    public Result<List<Comment>> listByArticle(@PathVariable Long articleId) {
        return Result.success(commentService.listByArticle(articleId));
    }

    @PostMapping("/user")
    @SaCheckLogin
    public Result<Long> create(@RequestBody CommentDTO dto) {
        return Result.success(commentService.create(dto));
    }

    @GetMapping("/admin/list")
    @SaCheckRole("admin")
    public Result<List<Comment>> adminList() {
        return Result.success(commentService.listAll());
    }

    @DeleteMapping("/admin/{id}")
    @SaCheckRole("admin")
    public Result<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return Result.success();
    }
}