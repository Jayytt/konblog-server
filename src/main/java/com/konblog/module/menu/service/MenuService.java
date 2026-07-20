package com.konblog.module.menu.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.menu.entity.Menu;
import java.util.List;
public interface MenuService extends IService<Menu> { List<Menu> tree(); List<Menu> listAll(); }