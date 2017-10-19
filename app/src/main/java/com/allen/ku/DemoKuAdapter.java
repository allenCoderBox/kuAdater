package com.allen.ku;

import android.content.Context;
import android.view.View;

import com.allen.ku.utils.CodeQuery;

/**
 * Created by husongzhen on 17/10/19.
 */

class DemoKuAdapter extends KuAdapter {
    public DemoKuAdapter(Context activity) {
        super(activity);
    }

    @Override
    public void onBindView(CodeQuery query, Object o, int i) {
        query.id(R.id.textView).text(o);

    }

    @Override
    public CodeQuery onCreateView(View view, int i) {
        return inflater(R.layout.ku_item, view);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
