package com.konblog.module.comment.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.comment.dto.CommentDTO;
import com.konblog.module.comment.entity.Comment;
import com.konblog.module.comment.mapper.CommentMapper;
import com.konblog.module.comment.service.CommentService;
import com.konblog.module.comment.vo.CommentVO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    private final UserMapper userMapper;

    public CommentServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<CommentVO> listByArticle(Long articleId) {
        List<Comment> comments = list(new LambdaQueryWrapper<Comment>().eq(Comment::getArticleId, articleId).orderByAsc(Comment::getCreateTime));
        return comments.stream().map(this::toVO).toList();
    }

    @Override
    public List<CommentVO> listAll() {
        List<Comment> comments = list(new LambdaQueryWrapper<Comment>().orderByDesc(Comment::getCreateTime));
        return comments.stream().map(this::toVO).toList();
    }

    @Override
    public Long create(CommentDTO dto) {
        Comment c = new Comment();
        BeanUtils.copyProperties(dto, c);
        save(c);
        return c.getId();
    }

    @Override
    public void delete(Long id) { removeById(id); }

    private CommentVO toVO(Comment c) {
        CommentVO vo = new CommentVO();
        BeanUtils.copyProperties(c, vo);
        if (c.getCreateBy() != null) {
            User user = userMapper.selectById(c.getCreateBy());
            if (user != null) {
                vo.setCreateUserName(user.getNickName() != null ? user.getNickName() : user.getUserName());
                vo.setCreateUserAvatar(user.getAvatar());
            }
        }
        return vo;
    }
}