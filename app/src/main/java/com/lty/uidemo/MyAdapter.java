package com.lty.uidemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    public OnItemClickListener OnItemClickListener = null;


    public void setOnItemClickListener(MyAdapter.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void OnItemClicked(int position);
    }

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public Button btn = null;

        public ViewHolder(View itemView) {
            super(itemView);
            btn = (Button) itemView;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button btn = new Button(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(btn);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.btn.setText(data.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OnItemClickListener != null) {
                    OnItemClickListener.OnItemClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}