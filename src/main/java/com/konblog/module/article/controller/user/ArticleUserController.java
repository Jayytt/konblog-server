package com.konblog.module.article.controller.user;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.article.service.ArticleService;
import com.konblog.module.article.vo.ArticleDetailVO;
import com.konblog.module.article.vo.ArticleListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(\