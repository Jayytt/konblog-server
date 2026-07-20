package com.konblog.module.comment;

import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import com.konblog.module.comment.mapper.CommentMapper;
import com.konblog.module.comment.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @Mock private CommentMapper commentMapper;
    @InjectMocks private CommentServiceImpl commentService;

    @Test
    void create_returnsId() {
        when(commentMapper.insert(any(Comment.class))).thenReturn(1);
        var dto = new CommentDTO(); dto.setContent("test"); dto.setArticleId(1L);
        Long id = commentService.create(dto);
        assertNotNull(id);
    }

    @Test
    void listByArticle_filtersCorrectly() {
        when(commentMapper.selectList(any())).thenReturn(List.of(new Comment()));
        var list = commentService.listByArticle(1L);
        assertFalse(list.isEmpty());
    }
}