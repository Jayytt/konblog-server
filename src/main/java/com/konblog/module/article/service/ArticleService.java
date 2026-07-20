package com.konblog.module.article.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.common.result.PageVO;
import com.konblog.module.article.dto.AddArticleDTO;
import com.konblog.module.article.entity.Article;
import com.konblog.module.article.vo.ArticleDetailVO;
import com.konblog.module.article.vo.ArticleListVO;

public interface ArticleService extends IService<Article> {
    PageVO<ArticleListVO> pageList(long current, long size);
    ArticleDetailVO getDetail(Long id);
    Long create(AddArticleDTO dto);
    void updateArticle(AddArticleDTO dto);
    void delete(Long id);
}