package com.allen.ku;

import android.view.View;

import com.allen.ku.utils.CodeQuery;

/**
 * Created by husongzhen on 17/10/19.
 */

interface IKuAdapter<T> {
    void onBindView(CodeQuery query, T o, int i);

    CodeQuery onCreateView(View parent, int p);

    void setRealAdapter(KuAdapter kuAdapter);
}

