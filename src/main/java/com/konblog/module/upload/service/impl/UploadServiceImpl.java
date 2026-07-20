package com.konblog.module.upload.service.impl;
import com.konblog.module.upload.service.UploadService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.BucketExistsArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);
    private final MinioClient minioClient;

    public UploadServiceImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Value("${upload.minio.bucket:konblog}") private String bucket;

    @Override
    public String upload(MultipartFile file) {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!exists) { minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build()); }
            String original = file.getOriginalFilename();
            String ext = original != null && original.contains(".") ? original.substring(original.lastIndexOf(".")) : "";
            String objectName = UUID.randomUUID().toString().replace("-", "") + ext;
            minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucket).object(objectName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType()).build());
            return String.format("%s/%s/%s", minioClient.getEndpoint(), bucket, objectName);
        } catch (Exception e) {
            log.error("Upload failed", e);
            throw new RuntimeException("Upload failed: " + e.getMessage());
        }
    }
}