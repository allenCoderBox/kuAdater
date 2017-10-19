package com.allen.ku;

import android.content.Context;
import android.view.View;

import com.allen.ku.utils.CodeQuery;

/**
 * Created by husongzhen on 17/10/19.
 */

class DemoBottomKuAdapter extends SuperKuAdapter<Object> {
    public DemoBottomKuAdapter(Context activity) {
        super(activity);
    }

    @Override
    public void onBindView(CodeQuery query, Object o, int i) {

    }

    @Override
    public CodeQuery onCreateView(View view, int i) {
        return inflater(R.layout.ku_bottom_item, view);
    }
}
