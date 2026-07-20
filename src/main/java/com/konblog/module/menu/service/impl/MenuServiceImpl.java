package com.konblog.module.menu.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.menu.entity.Menu;
import com.konblog.module.menu.mapper.MenuMapper;
import com.konblog.module.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override public List<Menu> tree() { return list(); }
    @Override public List<Menu> listAll() { return list(); }
}