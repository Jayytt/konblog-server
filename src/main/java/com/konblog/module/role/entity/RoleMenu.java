package com.konblog.module.role.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("sys_role_menu")
public class RoleMenu implements Serializable {
    @TableId(type = IdType.AUTO) private Long id; private Long roleId, menuId;
}