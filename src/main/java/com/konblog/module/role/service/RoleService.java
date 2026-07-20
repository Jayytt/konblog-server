package com.konblog.module.role.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.role.dto.RoleDTO;
import com.konblog.module.role.entity.Role;
import java.util.List;
public interface RoleService extends IService<Role> {
    List<Role> listAll();
    void create(RoleDTO dto); void update(RoleDTO dto); void delete(Long id);
    List<Long> getMenuIds(Long roleId); void assignMenus(Long roleId, List<Long> menuIds);
}