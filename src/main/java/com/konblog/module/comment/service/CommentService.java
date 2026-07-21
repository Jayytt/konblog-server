package com.konblog.module.comment.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import com.konblog.module.comment.vo.CommentVO;
import java.util.List;

public interface CommentService extends IService<Comment> {
    List<CommentVO> listByArticle(Long articleId);
    List<CommentVO> listAll();
    Long create(CommentDTO dto);
    void delete(Long id);
}