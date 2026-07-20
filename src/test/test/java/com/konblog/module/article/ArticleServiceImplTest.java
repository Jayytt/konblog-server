package com.konblog.module.article;

import com.konblog.module.article.entity.Article;
import com.konblog.module.article.mapper.ArticleMapper;
import com.konblog.module.article.mapper.ArticleTagMapper;
import com.konblog.module.article.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {

    @Mock
    private ArticleMapper articleMapper;
    @Mock
    private ArticleTagMapper articleTagMapper;
    @Mock
    private DataSource dataSource;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Test
    void delete_callsMapper() {
        doNothing().when(articleMapper).deleteById(1L);
        articleService.delete(1L);
        verify(articleMapper).deleteById(1L);
    }

    @Test
    void getDetail_returnsNullWhenNotFound() {
        when(articleMapper.selectById(999L)).thenReturn(null);
        var result = articleService.getDetail(999L);
        assertNull(result);
    }
}