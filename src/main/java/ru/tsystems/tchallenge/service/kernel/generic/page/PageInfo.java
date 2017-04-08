package ru.tsystems.tchallenge.service.kernel.generic.page;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class PageInfo<T extends GenericInfo> extends GenericInfo {

    private Collection<T> items;
    private Integer serial;
    private Integer size;
    private Integer total;

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
