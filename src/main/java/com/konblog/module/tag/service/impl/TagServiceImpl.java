package com.konblog.module.tag.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.tag.dto.TagDTO;
import com.konblog.module.tag.entity.Tag;
import com.konblog.module.tag.mapper.TagMapper;
import com.konblog.module.tag.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Override public List<Tag> listAll() {
        return list(new LambdaQueryWrapper<Tag>().orderByAsc(Tag::getCreateTime));
    }
    @Override public Long create(TagDTO dto) {
        Tag t = new Tag(); BeanUtils.copyProperties(dto, t); save(t); return t.getId();
    }
    @Override public void update(TagDTO dto) {
        Tag t = getById(dto.getId());
        if (t == null) return; BeanUtils.copyProperties(dto, t, "id"); updateById(t);
    }
    @Override public void delete(Long id) { removeById(id); }
}