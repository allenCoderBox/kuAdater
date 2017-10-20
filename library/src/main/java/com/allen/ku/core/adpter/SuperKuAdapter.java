package com.allen.ku.core.adpter;

import android.content.Context;
import android.view.View;

import com.allen.ku.utils.CodeQuery;

/**
 * Created by husongzhen on 17/10/19.
 */

public abstract class SuperKuAdapter<T> implements IKuAdapter<T> {


    private Context activity;
    private KuAdapter realAdapter;


    public SuperKuAdapter(Context activity) {
        this.activity = activity;
    }


    @Override
    public void setRealAdapter(KuAdapter kuAdapter) {
        this.realAdapter = kuAdapter;
    }


    public CodeQuery inflater(int layout, View view) {
        return realAdapter.inflater(layout, view);
    }

}
