package com.konblog.module.link.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.konblog.module.link.dto.LinkDTO;
import com.konblog.module.link.entity.Link;
import com.konblog.module.link.mapper.LinkMapper;
import com.konblog.module.link.service.LinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    @Override public List<Link> listAll() {
        return list(new LambdaQueryWrapper<Link>().orderByAsc(Link::getCreateTime));
    }
    @Override public Long create(LinkDTO dto) {
        Link l = new Link(); BeanUtils.copyProperties(dto, l); save(l); return l.getId();
    }
    @Override public void update(LinkDTO dto) {
        Link l = getById(dto.getId());
        if (l == null) return; BeanUtils.copyProperties(dto, l, "id"); updateById(l);
    }
    @Override public void delete(Long id) { removeById(id); }
}