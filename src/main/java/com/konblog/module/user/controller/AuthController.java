package com.konblog.module.user.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.konblog.annotation.SystemLog;
import com.konblog.common.result.Result;
import com.konblog.module.user.dto.LoginDTO;
import com.konblog.module.user.service.AuthService;
import com.konblog.module.user.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @SystemLog("用户登录")
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO dto) { return Result.success(authService.login(dto)); }

    @SystemLog("用户登出")
    @PostMapping("/logout")
    public Result<Void> logout() { authService.logout(); return Result.success(); }
}