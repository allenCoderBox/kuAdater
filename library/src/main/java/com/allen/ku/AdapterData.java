package com.allen.ku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by husongzhen on 17/10/19.
 */

public class AdapterData {
    private List<Object> footer = new ArrayList<>();
    private List<Object> header = new ArrayList<>();

    private List<Object> data = new ArrayList<>();


    public int size() {
        return data.size();
    }


    public <M> void reloadData(List<M> data) {
        this.data = (List<Object>) data;
    }

    public <M> void addAll(List<M> data) {
        this.data.removeAll(footer);
        this.data.addAll(data);
        this.data.addAll(footer);
    }

    public <M> int indexOf(M m) {
        return data.indexOf(m);
    }

    public void remove(int p) {
        Object obj = data.remove(p);
        if (footer.contains(obj)) {
            footer.remove(obj);
        }
    }

    public <M> M get(int p) {
        return (M) data.get(p);
    }

    public <M> List<M> getData() {
        return (List<M>) data;
    }

    public <M> boolean contains(M item) {
        return data.contains(item);
    }

    public <M> void add(int index, M item) {
        data.removeAll(header);
        data.add(index, item);
        data.addAll(0, header);
    }

    public <M> void set(int index, M item) {
        data.set(index, item);
    }

    public void clear() {
        data.clear();
        footer.clear();
    }

    public <M> void add(M item) {
        data.removeAll(footer);
        data.add(item);
        data.addAll(footer);
    }

    public void addFooter(Object obj) {
        footer.add(obj);
        data.add(obj);
    }

    public void addHeader(Object obj) {
        header.add(obj);
        data.add(0, obj);
    }
}
