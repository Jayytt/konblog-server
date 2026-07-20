package com.konblog.module.comment.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import com.konblog.module.comment.mapper.CommentMapper;
import com.konblog.module.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override public List<Comment> listByArticle(Long articleId) {
        return list(new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, articleId).orderByAsc(Comment::getCreateTime));
    }
    @Override public List<Comment> listAll() {
        return list(new LambdaQueryWrapper<Comment>().orderByDesc(Comment::getCreateTime));
    }
    @Override public Long create(CommentDTO dto) {
        Comment c = new Comment(); BeanUtils.copyProperties(dto, c); save(c); return c.getId();
    }
    @Override public void delete(Long id) { removeById(id); }
}