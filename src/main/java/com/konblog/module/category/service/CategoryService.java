package com.konblog.module.category.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.category.dto.CategoryDTO;
import com.konblog.module.category.entity.Category;
import com.konblog.module.category.vo.CategoryVO;
import java.util.List;
public interface CategoryService extends IService<Category> {
    List<CategoryVO> listAll();
    Long create(CategoryDTO dto); void update(CategoryDTO dto); void delete(Long id);
}