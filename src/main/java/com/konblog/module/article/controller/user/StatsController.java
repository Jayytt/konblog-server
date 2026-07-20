package com.konblog.module.article.controller.user;
import com.konblog.common.result.Result;
import com.konblog.module.article.mapper.ArticleMapper;
import com.konblog.module.category.mapper.CategoryMapper;
import com.konblog.module.tag.mapper.TagMapper;
import com.konblog.module.comment.mapper.CommentMapper;
import com.konblog.module.link.mapper.LinkMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final ArticleMapper articleMapper;
    private final CategoryMapper categoryMapper;
    private final TagMapper tagMapper;
    private final CommentMapper commentMapper;
    private final LinkMapper linkMapper;

    public StatsController(ArticleMapper articleMapper, CategoryMapper categoryMapper, TagMapper tagMapper, CommentMapper commentMapper, LinkMapper linkMapper) {
        this.articleMapper = articleMapper; this.categoryMapper = categoryMapper; this.tagMapper = tagMapper; this.commentMapper = commentMapper; this.linkMapper = linkMapper;
    }

    @GetMapping public Result<Map<String, Long>> stats() {
        Map<String, Long> map = new HashMap<>();
        map.put("articles", articleMapper.selectCount(null));
        map.put("categories", categoryMapper.selectCount(null));
        map.put("tags", tagMapper.selectCount(null));
        map.put("comments", commentMapper.selectCount(null));
        map.put("links", linkMapper.selectCount(null));
        return Result.success(map);
    }
}