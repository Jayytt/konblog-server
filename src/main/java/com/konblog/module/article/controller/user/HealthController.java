package com.konblog.module.article.controller.user;
import com.konblog.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health") public Result<Map<String,String>> health() { return Result.success(Map.of("status","UP","app","konblog-server","ver","1.0.0")); }
}