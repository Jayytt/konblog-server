package com.konblog.module.category.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
@Data public class CategoryVO {
    private Long id; private String name, description, status; private Long articleCount;
    @JsonFormat(pattern=\