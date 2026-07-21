package com.konblog.module.user.controller;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.konblog.annotation.SystemLog;
import com.konblog.common.result.Result;
import com.konblog.module.user.dto.LoginDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.mapper.UserMapper;
import com.konblog.module.user.service.AuthService;
import com.konblog.module.user.vo.LoginVO;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserMapper userMapper;

    public AuthController(AuthService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @SystemLog("login")
    @PostMapping("/login") public Result<LoginVO> login(@RequestBody LoginDTO dto) { return Result.success(authService.login(dto)); }

    @SystemLog("logout")
    @PostMapping("/logout") public Result<Void> logout() { StpUtil.logout(); return Result.success(); }

    @SaCheckLogin
    @GetMapping("/info")
    public Result<Map<String, Object>> info() {
        Long userId = StpUtil.getLoginIdAsLong();
        User user = userMapper.selectById(userId);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put("id", user.getId());
            map.put("userName", user.getUserName());
            map.put("nickName", user.getNickName());
            map.put("avatar", user.getAvatar());
        }
        return Result.success(map);
    }
}