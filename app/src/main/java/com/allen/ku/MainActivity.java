package com.allen.ku;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private KuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.textView3).setOnClickListener(this);
        initList();
        initData();
        adapter.addFooter("bottom");
        adapter.addFooter("bottom");
        adapter.addFooter("bottom");
        adapter.addFooter("bottom");
        adapter.addFooter("bottom");
        adapter.addHeader("header");
    }

    private void initData() {
        List<String> data = getStrings();
        adapter.reloadData(data);
    }

    @NonNull
    private List<String> getStrings() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("item--" + i);
        }
        return data;
    }

    private void initList() {
        DemoBottomKuAdapter bottomKuAdapter = new DemoBottomKuAdapter(this);
        DemoKuAdapter demoAdapter = new DemoKuAdapter(this);
        adapter = new KuAdapter(this) {
            @Override
            public int getItemViewType(int position) {
                if (getItem(position).equals("bottom")) {
                    return "bottom".hashCode();
                } else {
                    return "nomal".hashCode();
                }
            }
        };
        adapter.registerHolder("bottom", bottomKuAdapter);
        adapter.registerHolder("nomal", demoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textView2) {
            adapter.addAll(getStrings());
        }

        if (v.getId() == R.id.textView3) {
            adapter.add(0, "husongzhen");
        }
    }
}
