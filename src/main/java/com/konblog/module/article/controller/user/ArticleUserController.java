package com.konblog.module.article.controller.user;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.article.service.ArticleService;
import com.konblog.module.article.vo.ArticleDetailVO;
import com.konblog.module.article.vo.ArticleListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article/user")
@RequiredArgsConstructor
public class ArticleUserController {
    private final ArticleService articleService;
    @GetMapping("/page") public Result<PageVO<ArticleListVO>> page(@RequestParam(defaultValue="1") long current, @RequestParam(defaultValue="10") long size) {
        return Result.success(articleService.pageList(current, size));
    }
    @GetMapping("/{id}") public Result<ArticleDetailVO> detail(@PathVariable Long id) {
        return Result.success(articleService.getDetail(id));
    }
}