package com.konblog.module.category;

import com.konblog.module.category.dto.CategoryDTO;
import com.konblog.module.category.entity.Category;
import com.konblog.module.category.mapper.CategoryMapper;
import com.konblog.module.category.service.impl.CategoryServiceImpl;
import com.konblog.module.category.vo.CategoryVO;
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
class CategoryServiceImplTest {

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void create_returnsId() {
        Category entity = new Category();
        entity.setId(1L);
        when(categoryMapper.insert(any(Category.class))).thenReturn(1);

        var dto = new CategoryDTO();
        dto.setName("Music");
        dto.setDescription("All about music");

        Long id = categoryService.create(dto);
        assertNotNull(id);
        verify(categoryMapper, times(1)).insert(any(Category.class));
    }

    @Test
    void listAll_returnsList() {
        Category c1 = new Category(); c1.setId(1L); c1.setName("Music");
        Category c2 = new Category(); c2.setId(2L); c1.setName("Tech");
        when(categoryMapper.selectList(any())).thenReturn(List.of(c1, c2));

        List<CategoryVO> result = categoryService.listAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}