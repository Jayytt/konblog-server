package com.konblog.module.article.controller.admin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.annotation.SystemLog;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.article.dto.AddArticleDTO;
import com.konblog.module.article.service.ArticleService;
import com.konblog.module.article.vo.ArticleListVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article/admin")
@SaCheckRole("admin")
public class ArticleAdminController {
    private final ArticleService articleService;
    public ArticleAdminController(ArticleService articleService) { this.articleService = articleService; }

    @SystemLog("page")
    @GetMapping("/page") public Result<PageVO<ArticleListVO>> page(@RequestParam(defaultValue="1") long current, @RequestParam(defaultValue="10") long size) {
        return Result.success(articleService.pageList(current, size));
    }
    @SystemLog("create")
    @PostMapping public Result<Long> create(@RequestBody AddArticleDTO dto) { return Result.success(articleService.create(dto)); }
    @SystemLog("update")
    @PutMapping public Result<Void> update(@RequestBody AddArticleDTO dto) { articleService.updateArticle(dto); return Result.success(); }
    @SystemLog("delete")
    @DeleteMapping("/{id}") public Result<Void> delete(@PathVariable Long id) { articleService.delete(id); return Result.success(); }
}