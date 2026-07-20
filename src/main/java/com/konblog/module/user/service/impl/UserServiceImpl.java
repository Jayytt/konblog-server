package com.konblog.module.user.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.user.dto.UserDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.entity.UserRole;
import com.konblog.module.user.mapper.UserMapper;
import com.konblog.module.user.mapper.UserRoleMapper;
import com.konblog.module.user.service.UserService;
import com.konblog.module.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserRoleMapper userRoleMapper;
    private final PasswordEncoder passwordEncoder;

    private List<Long> getRoleIdsInternal(Long userId) {
        return userRoleMapper.selectList(new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId)).stream().map(UserRole::getRoleId).toList();
    }

    @Override public List<UserVO> listAll() {
        return list().stream().map(u -> {
            UserVO vo = new UserVO(); BeanUtils.copyProperties(u, vo); vo.setRoleIds(getRoleIdsInternal(u.getId()));
            return vo;
        }).toList();
    }
    @Override public UserVO getById(Long id) {
        User u = super.getById(id); UserVO vo = new UserVO(); BeanUtils.copyProperties(u, vo); vo.setRoleIds(getRoleIdsInternal(id)); return vo;
    }
    @Override @Transactional public void create(UserDTO dto) {
        User u = new User(); BeanUtils.copyProperties(dto, u);
        if (dto.getPassword() != null && !dto.getPassword().startsWith("$2a")) {
            u.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        save(u);
        if (dto.getRoleIds() != null) {
            for (Long rid : dto.getRoleIds()) { UserRole ur = new UserRole(); ur.setUserId(u.getId()); ur.setRoleId(rid); userRoleMapper.insert(ur); }
        }
    }
    @Override @Transactional public void update(UserDTO dto) {
        User u = getById(dto.getId()); if (u == null) return;
        BeanUtils.copyProperties(dto, u, "id", "password"); updateById(u);
        userRoleMapper.delete(new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, dto.getId()));
        if (dto.getRoleIds() != null) {
            for (Long rid : dto.getRoleIds()) { UserRole ur = new UserRole(); ur.setUserId(dto.getId()); ur.setRoleId(rid); userRoleMapper.insert(ur); }
        }
    }
    @Override public void delete(Long id) { removeById(id); }
    @Override public List<Long> getRoleIds(Long userId) { return getRoleIdsInternal(userId); }
    @Override public void assignRoles(Long userId, List<Long> roleIds) {
        for (Long rid : roleIds) { UserRole ur = new UserRole(); ur.setUserId(userId); ur.setRoleId(rid); userRoleMapper.insert(ur); }
    }
}