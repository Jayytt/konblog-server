package com.konblog.common.result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

public class PageVO<T> {
    private List<T> records; private long total; private long current; private long size;

    public List<T> getRecords() { return records; }
    public void setRecords(List<T> records) { this.records = records; }
    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }
    public long getCurrent() { return current; }
    public void setCurrent(long current) { this.current = current; }
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }

    public static <T> PageVO<T> of(IPage<T> p) {
        PageVO<T> v = new PageVO<>(); v.setRecords(p.getRecords()); v.setTotal(p.getTotal()); v.setCurrent(p.getCurrent()); v.setSize(p.getSize()); return v;
    }
}