package com.allen.ku.core.adpter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

import com.allen.ku.utils.CodeQuery;

import java.util.List;

/**
 * 作者：husongzhen on 17/8/8 14:32
 * 邮箱：husongzhen@musikid.com
 *
 * @author husongzhen
 */

public class KuAdapter extends CodeSuperRecyclerAdapter<Object> implements IKuAdapter {
    private SparseArray<IKuAdapter> types = new SparseArray<>();
    private KuAdapter realAdapter;

    public KuAdapter(Context activity) {
        super(activity);
    }

    public void registerHolder(Object obj, IKuAdapter itemHolder) {
        itemHolder.setRealAdapter(this);
        types.put(obj.hashCode(), itemHolder);
    }


    @Override
    public int getItemViewType(int position) {
        Object item = getItem(position);
        int viewTypeCode = onCreateType(item);
        return viewTypeCode;
    }

    @Override
    public void reloadData(List data) {
        super.reloadData(data);
    }


    @Override
    public void addAll(List list) {
        super.addAll(list);
    }

    protected int onCreateType(Object item) {
        return item.getClass().hashCode();
    }

    @Override
    public void onBindView(CodeQuery query, Object o, int i) {
        int typeKey = getItemViewType(i);
        types.get(typeKey).onBindView(query, o, i);
    }


    @Override
    public CodeQuery onCreateView(View parent, int p) {
        IKuAdapter itemHolder = types.get(p);
        return itemHolder.onCreateView(parent, p);
    }

    @Override
    public void setRealAdapter(KuAdapter kuAdapter) {
        this.realAdapter = kuAdapter;
    }

    public KuAdapter getRealAdapter() {
        return realAdapter;
    }
}
