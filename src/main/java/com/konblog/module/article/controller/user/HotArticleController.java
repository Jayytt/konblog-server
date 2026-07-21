package com.konblog.module.article.controller.user;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.konblog.common.result.Result;
import com.konblog.module.article.entity.Article;
import com.konblog.module.article.mapper.ArticleMapper;
import com.konblog.module.article.vo.ArticleListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/article/user")
public class HotArticleController {
    private final ArticleMapper articleMapper;

    public HotArticleController(ArticleMapper articleMapper) { this.articleMapper = articleMapper; }

    @GetMapping("/hot")
    public Result<List<ArticleListVO>> hot(@RequestParam(defaultValue = "5") int limit) {
        List<Article> articles = articleMapper.selectList(
            new LambdaQueryWrapper<Article>()
                .eq(Article::getStatus, "0")
                .orderByDesc(Article::getViewCount)
                .last("LIMIT " + limit)
        );
        List<ArticleListVO> vos = articles.stream().map(a -> {
            ArticleListVO vo = new ArticleListVO();
            BeanUtils.copyProperties(a, vo);
            return vo;
        }).toList();
        return Result.success(vos);
    }
}