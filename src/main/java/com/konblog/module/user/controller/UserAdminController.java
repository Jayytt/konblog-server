package com.konblog.module.user.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.user.dto.UserDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.service.UserService;
import com.konblog.module.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(\