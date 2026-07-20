package com.konblog.module.upload.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.common.result.Result;
import com.konblog.module.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@SaCheckRole("admin")
@RequiredArgsConstructor
public class UploadController {
    private final UploadService uploadService;
    @PostMapping public Result<String> upload(@RequestParam("file") MultipartFile file) {
        return Result.success(uploadService.upload(file));
    }
}