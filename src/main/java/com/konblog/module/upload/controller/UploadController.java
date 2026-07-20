package com.konblog.module.upload.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.upload.service.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@SaCheckRole("admin")
public class UploadController {
    private final UploadService uploadService;
    public UploadController(UploadService uploadService) { this.uploadService = uploadService; }
    @PostMapping public Result<String> upload(@RequestParam("file") MultipartFile file) { return Result.success(uploadService.upload(file)); }
}