package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.MatchData;
import com.teach.teach10zl.R;
import com.yiyatech.android.utils.DateUtils;

import java.util.List;

/**
 * Created by 任小龙 on 2019/4/26.
 */
public class MatchFatherAdapter extends RecyclerView.Adapter<MatchFatherAdapter.ViewHolder> {
    private List<MatchData.Data> mContentsBeanList;
    private Context mContext;

    public MatchFatherAdapter(List<MatchData.Data> pContentsBeanList, Context pContext) {
        mContentsBeanList = pContentsBeanList;
        mContext = pContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.hot_father_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String week = mContentsBeanList.get(position).itemData.get(0).week;
        String month = mContentsBeanList.get(position).itemData.get(0).md;
        holder.mTextView.setText(month+" "+week);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        holder.mRecyclerView.setLayoutManager(manager);
        MatchChildAdapter adapter = new MatchChildAdapter(mContext,mContentsBeanList.get(position).itemData);
        holder.mRecyclerView.setAdapter(adapter);
        holder.mRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return mContentsBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        RecyclerView mRecyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.recyclerView);
            mTextView = itemView.findViewById(R.id.title_days);
        }
    }
}
