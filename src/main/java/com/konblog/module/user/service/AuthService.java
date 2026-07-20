package com.konblog.module.user.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.konblog.common.exception.BusinessException;
import com.konblog.common.result.ErrorCode;
import com.konblog.module.user.dto.LoginDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.mapper.UserMapper;
import com.konblog.module.user.vo.LoginVO;
import cn.dev33.satoken.stp.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public LoginVO login(LoginDTO dto) {
        User u = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, dto.getUsername()));
        if (u == null) throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        if (!passwordEncoder.matches(dto.getPassword(), u.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_ERROR);
        }
        StpUtil.login(u.getId());
        SaSession s = StpUtil.getSession();
        s.set("roles", List.of("admin"));
        s.set("permissions", List.of("*"));
        LoginVO vo = new LoginVO();
        vo.setToken(StpUtil.getTokenValue()); vo.setUserId(u.getId());
        vo.setUsername(u.getUserName()); vo.setNickName(u.getNickName()); vo.setAvatar(u.getAvatar());
        return vo;
    }

    public void logout() { StpUtil.logout(); }
}