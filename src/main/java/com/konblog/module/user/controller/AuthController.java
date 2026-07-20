package com.konblog.module.user.controller;
import com.konblog.annotation.SystemLog;
import com.konblog.common.result.Result;
import com.konblog.module.user.dto.LoginDTO;
import com.konblog.module.user.service.AuthService;
import com.konblog.module.user.vo.LoginVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @SystemLog("login")
    @PostMapping("/login") public Result<LoginVO> login(@RequestBody LoginDTO dto) { return Result.success(authService.login(dto)); }
    @SystemLog("logout")
    @PostMapping("/logout") public Result<Void> logout() { authService.logout(); return Result.success(); }
}