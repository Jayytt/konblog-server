package com.konblog.module.tag.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.tag.dto.TagDTO;
import com.konblog.module.tag.entity.Tag;
import java.util.List;

public interface TagService extends IService<Tag> {
    List<Tag> listAll();
    Long create(TagDTO dto);
    void updateTag(TagDTO dto);
    void delete(Long id);
}