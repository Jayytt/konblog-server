package com.konblog.module.article.controller.admin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.annotation.SystemLog;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.article.dto.AddArticleDTO;
import com.konblog.module.article.service.ArticleService;
import com.konblog.module.article.vo.ArticleListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article/admin")
@SaCheckRole("admin")
@RequiredArgsConstructor
public class ArticleAdminController {
    private final ArticleService articleService;

    @SystemLog("分页查询文章")
    @GetMapping("/page")
    public Result<PageVO<ArticleListVO>> page(@RequestParam(defaultValue="1") long current, @RequestParam(defaultValue="10") long size) {
        return Result.success(articleService.pageList(current, size));
    }

    @SystemLog("创建文章")
    @PostMapping
    public Result<Long> create(@RequestBody AddArticleDTO dto) { return Result.success(articleService.create(dto)); }

    @SystemLog("更新文章")
    @PutMapping
    public Result<Void> update(@RequestBody AddArticleDTO dto) { articleService.update(dto); return Result.success(); }

    @SystemLog("删除文章")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) { articleService.delete(id); return Result.success(); }
}