package com.konblog.module.category.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.category.dto.CategoryDTO;
import com.konblog.module.category.entity.Category;
import com.konblog.module.category.mapper.CategoryMapper;
import com.konblog.module.category.service.CategoryService;
import com.konblog.module.category.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override public List<CategoryVO> listAll() {
        return list(new LambdaQueryWrapper<Category>().orderByAsc(Category::getCreateTime)).stream().map(c -> {
            CategoryVO vo = new CategoryVO(); BeanUtils.copyProperties(c, vo); return vo;
        }).toList();
    }
    @Override public Long create(CategoryDTO dto) {
        Category e = new Category(); BeanUtils.copyProperties(dto, e); save(e); return e.getId();
    }
    @Override public void update(CategoryDTO dto) {
        Category e = getById(dto.getId());
        if (e == null) return;
        BeanUtils.copyProperties(dto, e, "id");
        updateById(e);
    }
    @Override public void delete(Long id) { removeById(id); }
}