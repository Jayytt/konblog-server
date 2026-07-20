package com.konblog.module.user.controller;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.konblog.common.result.PageVO;
import com.konblog.common.result.Result;
import com.konblog.module.user.dto.UserDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.service.UserService;
import com.konblog.module.user.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@SaCheckRole("admin")
public class UserAdminController {
    private final UserService userService;
    public UserAdminController(UserService userService) { this.userService = userService; }

    @GetMapping("/admin/page") public Result<PageVO<UserVO>> page(@RequestParam(defaultValue="1") long current, @RequestParam(defaultValue="10") long size) {
        Page<User> p = userService.page(new Page<>(current, size));
        List<UserVO> vos = p.getRecords().stream().map(u -> {
            UserVO vo = new UserVO(); BeanUtils.copyProperties(u, vo); vo.setRoleIds(userService.getRoleIds(u.getId())); return vo;
        }).toList();
        Page<UserVO> vp = new Page<>(current, size, p.getTotal()); vp.setRecords(vos);
        return Result.success(PageVO.of(vp));
    }
    @PostMapping("/admin") public Result<Void> create(@RequestBody UserDTO dto) { userService.create(dto); return Result.success(); }
    @PutMapping("/admin") public Result<Void> update(@RequestBody UserDTO dto) { userService.update(dto); return Result.success(); }
    @DeleteMapping("/admin/{id}") public Result<Void> delete(@PathVariable Long id) { userService.delete(id); return Result.success(); }
}