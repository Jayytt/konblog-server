package com.konblog.common.result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import java.util.List;
@Data
public class PageVO<T> {
    private List<T> records; private long total; private long current; private long size;
    public static <T> PageVO<T> of(IPage<T> p) {
        PageVO<T> v = new PageVO<>(); v.setRecords(p.getRecords()); v.setTotal(p.getTotal()); v.setCurrent(p.getCurrent()); v.setSize(p.getSize()); return v;
    }
}