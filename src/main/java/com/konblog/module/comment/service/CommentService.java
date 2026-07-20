package com.konblog.module.comment.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import java.util.List;
public interface CommentService extends IService<Comment> {
    List<Comment> listByArticle(Long articleId);
    List<Comment> listAll();
    Long create(CommentDTO dto);
    void delete(Long id);
}