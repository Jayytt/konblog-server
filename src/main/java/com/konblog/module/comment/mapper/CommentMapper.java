package com.konblog.module.comment.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.konblog.module.comment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
@Mapper public interface CommentMapper extends BaseMapper<Comment> {}