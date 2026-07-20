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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
    private final ArticleTagMapper articleTagMapper;
    private final DataSource dataSource;

    public ArticleServiceImpl(ArticleTagMapper articleTagMapper, DataSource dataSource) {
        this.articleTagMapper = articleTagMapper;
        this.dataSource = dataSource;
    }

    @Override
    public PageVO<ArticleListVO> pageList(long current, long size) {
        Page<Article> page = articleMapper.selectPage(new Page<>(current, size),
            new LambdaQueryWrapper<Article>().orderByDesc(Article::getIsTop, Article::getCreateTime));
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        List<ArticleListVO> vos = page.getRecords().stream().map(a -> {
            ArticleListVO vo = new ArticleListVO();
            BeanUtils.copyProperties(a, vo);
            try { vo.setCategoryName(jdbc.queryForObject("SELECT name FROM sg_category WHERE id = ?", String.class, a.getCategoryId())); }
            catch (Exception e) { vo.setCategoryName("未分类"); }
            return vo;
        }).toList();
        Page<ArticleListVO> voPage = new Page<>(current, size, page.getTotal());
        voPage.setRecords(vos);
        return PageVO.of(voPage);
    }

    @Override
    public ArticleDetailVO getDetail(Long id) {
        Article a = articleMapper.selectById(id);
        if (a == null) return null;
        a.setViewCount((a.getViewCount() == null ? 0 : a.getViewCount()) + 1);
        articleMapper.updateById(a);
        ArticleDetailVO vo = new ArticleDetailVO();
        BeanUtils.copyProperties(a, vo);
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        try { vo.setCategoryName(jdbc.queryForObject("SELECT name FROM sg_category WHERE id = ?", String.class, a.getCategoryId())); }
        catch (Exception e) { vo.setCategoryName("未分类"); }
        return vo;
    }

    @Override @Transactional
    public Long create(AddArticleDTO dto) {
        Article a = new Article();
        BeanUtils.copyProperties(dto, a);
        a.setViewCount(0L);
        articleMapper.insert(a);
        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                ArticleTag at = new ArticleTag();
                at.setArticleId(a.getId()); at.setTagId(tagId);
                articleTagMapper.insert(at);
            }
        }
        return a.getId();
    }

    @Override @Transactional
    public void updateArticle(AddArticleDTO dto) {
        Article a = articleMapper.selectById(dto.getId());
        if (a == null) return;
        BeanUtils.copyProperties(dto, a, "id");
        articleMapper.updateById(a);
        articleTagMapper.delete(new LambdaQueryWrapper<ArticleTag>().eq(ArticleTag::getArticleId, dto.getId()));
        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                ArticleTag at = new ArticleTag();
                at.setArticleId(dto.getId()); at.setTagId(tagId);
                articleTagMapper.insert(at);
            }
        }
    }

    @Override public void delete(Long id) { articleMapper.deleteById(id); }
}