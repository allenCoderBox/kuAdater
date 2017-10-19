package com.allen.ku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allen.ku.utils.CodeCheck;
import com.allen.ku.utils.CodeQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by husongzhen on 15/7/23.
 */
public abstract class CodeSuperRecyclerAdapter<M> extends RecyclerView.Adapter<CodeSuperRecyclerAdapter.WebViewHolder>
        implements View.OnClickListener {


    protected List<M> dataList = new ArrayList<M>();
    protected Context activity;


    public CodeSuperRecyclerAdapter(Context activity) {
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(WebViewHolder holder, int i) {
        int index = getRealPosition(holder);
        onBindView(holder.query, dataList.get(index), i);
    }

    protected abstract void onBindView(CodeQuery query, M m, int position);


    @Override
    public WebViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CodeQuery query = onCreateView(parent, viewType);
        return new WebViewHolder(query);
    }

    protected abstract CodeQuery onCreateView(View parent, int p);

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return position;
    }


    public void reloadData(List<M> data) {
        // TODO Auto-generated method stub
        if (!CodeCheck.isNotNullList(data)) {
            data = new ArrayList<M>();
        }
        dataList = data;
        notifyDataSetChanged();
    }

    public void appendData(List<M> data) {
        // TODO Auto-generated method stub

        if (!CodeCheck.isNotNullList(data)) {
            return;
        }
        dataList.addAll(data);
        int startIndex = getItemCount() + 1;
        notifyItemRangeInserted(startIndex, data.size());
    }


    public void notifyData(M m) {
        if (CodeCheck.isNotNull(m)) {
            int index = dataList.indexOf(m);
            if (index != -1) {
                notifyItemChanged(index);
            }
        }
    }


    public void remove(int p) {
        if (p < 0) {
            return;
        }
        dataList.remove(p);
        notifyItemRemoved(p);
        if (p != dataList.size()) { // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(p, dataList.size() - p);
        }
    }


    public void remove(M m) {
        int index = indexOf(m);
        if (index >= 0) {
            remove(index);
        }
    }


    public M getItem(int p) {
        return dataList.get(p);
    }


    public List<M> getDataList() {
        return dataList;
    }

    public int indexOf(M item) {
        if (!dataList.contains(item)) {
            return -1;
        }
        int pos = dataList.indexOf(item);
        return pos;
    }

    public void addAll(List<M> list) {
        if (!CodeCheck.isNotNullList(list)) {
            return;
        }

        int startPos = getItemCount();
        dataList.addAll(list);
        notifyItemRangeInserted(startPos, list.size());
    }


    public void add(int index, M item) {
        if (!CodeCheck.isNotNull(item)) {
            return;
        }
        dataList.add(index, item);
        notifyItemInserted(index);
        updateHolderPos(index);
    }


    public void add(M item) {
        if (!CodeCheck.isNotNull(item)) {
            return;
        }
        int index = dataList.size();
        dataList.add(item);
        notifyItemInserted(index);
        updateHolderPos(index);
    }


    public void replace(M item) {
        if (!CodeCheck.isNotNull(item)) {
            return;
        }
        int index = indexOf(item);
        if (index != -1) {
            dataList.set(index, item);
            notifyItemChanged(index);
            updateHolderPos(index);
        }
    }


    public void updateHolderPos(int pos) {
        if (pos != dataList.size() - 1) {
            notifyItemRangeChanged(pos, dataList.size() - pos);
        }
    }

    public void clear() {
        dataList.clear();
        notifyDataSetChanged();
    }


    public static class WebViewHolder extends RecyclerView.ViewHolder {
        public CodeQuery query;

        public WebViewHolder(CodeQuery query) {
            super(query.getRoot());
            this.query = query;
        }

        public View getItemView() {
            return itemView;
        }
    }

    public CodeQuery inflater(int layout, View parent) {
        View root = LayoutInflater.from(activity).inflate(layout, (ViewGroup) parent, false);
        CodeQuery query = new CodeQuery(activity).setRoot(root);
        return query;
    }


}
