package com.konblog.module.role;

import com.konblog.module.role.entity.Role;
import com.konblog.module.role.mapper.RoleMapper;
import com.konblog.module.role.mapper.RoleMenuMapper;
import com.konblog.module.role.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {
    @Mock private RoleMapper roleMapper;
    @Mock private RoleMenuMapper roleMenuMapper;
    @InjectMocks private RoleServiceImpl roleService;

    @Test
    void listAll_returnsAll() {
        when(roleMapper.selectList(any())).thenReturn(List.of(new Role()));
        assertEquals(1, roleService.listAll().size());
    }

    @Test
    void assignMenus_inserts() {
        when(roleMenuMapper.insert(any())).thenReturn(1);
        roleService.assignMenus(1L, List.of(1L, 2L));
        verify(roleMenuMapper, times(2)).insert(any());
    }
}