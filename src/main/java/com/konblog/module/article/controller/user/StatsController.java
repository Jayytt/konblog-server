package com.konblog.module.article.controller.user;
import com.konblog.common.result.Result;
import com.konblog.module.article.mapper.ArticleMapper;
import com.konblog.module.category.mapper.CategoryMapper;
import com.konblog.module.tag.mapper.TagMapper;
import com.konblog.module.comment.mapper.CommentMapper;
import com.konblog.module.link.mapper.LinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(\