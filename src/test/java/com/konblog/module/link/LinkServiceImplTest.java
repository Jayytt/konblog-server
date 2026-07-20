package com.konblog.module.link;

import com.konblog.module.link.dto.LinkDTO;
import com.konblog.module.link.entity.Link;
import com.konblog.module.link.mapper.LinkMapper;
import com.konblog.module.link.service.impl.LinkServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {
    @Mock private LinkMapper linkMapper;
    @InjectMocks private LinkServiceImpl linkService;

    @Test
    void create_setsAllFields() {
        when(linkMapper.insert(any(Link.class))).thenReturn(1);
        var dto = new LinkDTO(); dto.setName("GitHub"); dto.setAddress("https://github.com");
        Long id = linkService.create(dto);
        assertNotNull(id);
        verify(linkMapper).insert(any(Link.class));
    }

    @Test
    void delete_callsMapper() {
        doNothing().when(linkMapper).deleteById(1L);
        linkService.delete(1L);
        verify(linkMapper).deleteById(1L);
    }
}