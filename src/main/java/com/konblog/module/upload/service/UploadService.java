package com.konblog.module.upload.service;
import org.springframework.web.multipart.MultipartFile;
public interface UploadService { String upload(MultipartFile file); }