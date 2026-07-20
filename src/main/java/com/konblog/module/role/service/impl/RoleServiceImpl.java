package com.konblog.module.role.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.role.dto.RoleDTO;
import com.konblog.module.role.entity.Role;
import com.konblog.module.role.entity.RoleMenu;
import com.konblog.module.role.mapper.RoleMapper;
import com.konblog.module.role.mapper.RoleMenuMapper;
import com.konblog.module.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    private final RoleMenuMapper roleMenuMapper;
    @Override public List<Role> listAll() { return list(); }
    @Override @Transactional public void create(RoleDTO dto) {
        Role r = new Role(); BeanUtils.copyProperties(dto, r); save(r);
        if (dto.getMenuIds() != null) assignMenus(r.getId(), dto.getMenuIds());
    }
    @Override @Transactional public void update(RoleDTO dto) {
        Role r = getById(dto.getId()); if (r == null) return;
        BeanUtils.copyProperties(dto, r, \