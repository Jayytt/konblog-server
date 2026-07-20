package com.konblog.module.tag;

import com.konblog.module.tag.dto.TagDTO;
import com.konblog.module.tag.entity.Tag;
import com.konblog.module.tag.mapper.TagMapper;
import com.konblog.module.tag.service.impl.TagServiceImpl;
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
class TagServiceImplTest {
    @Mock private TagMapper tagMapper;
    @InjectMocks private TagServiceImpl tagService;

    @Test
    void create_andList() {
        when(tagMapper.insert(any(Tag.class))).thenReturn(1);
        when(tagMapper.selectList(any())).thenReturn(List.of(new Tag(), new Tag()));

        var dto = new TagDTO(); dto.setName("Java");
        Long id = tagService.create(dto);
        assertNotNull(id);

        var list = tagService.listAll();
        assertEquals(2, list.size());
    }
}