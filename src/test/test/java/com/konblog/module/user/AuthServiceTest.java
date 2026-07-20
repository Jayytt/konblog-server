package com.konblog.module.user;

import com.konblog.common.exception.BusinessException;
import com.konblog.common.result.ErrorCode;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.mapper.UserMapper;
import com.konblog.module.user.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setUserName("admin");
        testUser.setPassword("$2a$10$hashed");
        testUser.setNickName("Admin");
    }

    @Test
    void login_success() {
        when(userMapper.selectOne(any())).thenReturn(testUser);
        when(passwordEncoder.matches("123456", "$2a$10$hashed")).thenReturn(true);

        var dto = new com.konblog.module.user.dto.LoginDTO();
        dto.setUsername("admin");
        dto.setPassword("123456");

        var vo = authService.login(dto);
        assertNotNull(vo);
        assertEquals("admin", vo.getUsername());
        assertEquals(1L, vo.getUserId());
        assertNotNull(vo.getToken());
    }

    @Test
    void login_userNotFound() {
        when(userMapper.selectOne(any())).thenReturn(null);

        var dto = new com.konblog.module.user.dto.LoginDTO();
        dto.setUsername("nobody");
        dto.setPassword("123456");

        var ex = assertThrows(BusinessException.class, () -> authService.login(dto));
        assertEquals(ErrorCode.USER_NOT_FOUND.getCode(), ex.getCode());
    }

    @Test
    void login_wrongPassword() {
        when(userMapper.selectOne(any())).thenReturn(testUser);
        when(passwordEncoder.matches("wrong", "$2a$10$hashed")).thenReturn(false);

        var dto = new com.konblog.module.user.dto.LoginDTO();
        dto.setUsername("admin");
        dto.setPassword("wrong");

        var ex = assertThrows(BusinessException.class, () -> authService.login(dto));
        assertEquals(ErrorCode.PASSWORD_ERROR.getCode(), ex.getCode());
    }
}