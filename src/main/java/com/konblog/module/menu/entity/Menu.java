package com.konblog.module.menu.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_menu")
public class Menu implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private String menuName, path, component, perms, icon, menuType, remark;
    private Long parentId; private Integer orderNum, isCache, visible, status;
    private LocalDateTime createTime, updateTime; private Long createBy, updateBy;
}