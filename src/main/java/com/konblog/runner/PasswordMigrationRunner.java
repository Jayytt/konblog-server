package com.konblog.runner;

import com.konblog.module.user.entity.User;
import com.konblog.module.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PasswordMigrationRunner implements ApplicationRunner {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        List<User> users = userMapper.selectList(null);
        for (User u : users) {
            String pwd = u.getPassword();
            if (pwd != null && !pwd.startsWith("$2a") && !pwd.startsWith("$2b")) {
                u.setPassword(passwordEncoder.encode(pwd));
                userMapper.updateById(u);
            }
        }
    }
}