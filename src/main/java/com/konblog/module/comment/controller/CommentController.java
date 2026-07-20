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
@RequestMapping(\