package com.konblog.module.link.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.konblog.module.link.dto.LinkDTO;
import com.konblog.module.link.entity.Link;
import java.util.List;

public interface LinkService extends IService<Link> {
    List<Link> listAll();
    Long create(LinkDTO dto);
    void updateLink(LinkDTO dto);
    void delete(Long id);
}