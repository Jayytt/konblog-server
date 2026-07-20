package com.konblog.module.article.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.common.result.PageVO;
import com.konblog.module.article.dto.AddArticleDTO;
import com.konblog.module.article.entity.Article;
import com.konblog.module.article.entity.ArticleTag;
import com.konblog.module.article.mapper.ArticleMapper;
import com.konblog.module.article.mapper.ArticleTagMapper;
import com.konblog.module.article.service.ArticleService;
import com.konblog.module.article.vo.ArticleDetailVO;
import com.konblog.module.article.vo.ArticleListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private final ArticleTagMapper articleTagMapper;
    private final DataSource dataSource;

    @Override
    public PageVO<ArticleListVO> pageList(long current, long size) {
        Page<Article> page = articleMapper.selectPage(new Page<>(current, size),
            new LambdaQueryWrapper<Article>().orderByDesc(Article::getIsTop, Article::getCreateTime));
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        List<ArticleListVO> vos = page.getRecords().stream().map(a -> {
            ArticleListVO vo = new ArticleListVO();
            BeanUtils.copyProperties(a, vo);
            try { vo.setCategoryName(jdbc.queryForObject(\