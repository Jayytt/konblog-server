package com.konblog.module.user.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.user.dto.UserDTO;
import com.konblog.module.user.entity.User;
import com.konblog.module.user.vo.UserVO;
import java.util.List;
public interface UserService extends IService<User> {
    List<UserVO> listAll(); UserVO getById(Long id);
    void create(UserDTO dto); void update(UserDTO dto); void delete(Long id);
    List<Long> getRoleIds(Long userId); void assignRoles(Long userId, List<Long> roleIds);
}