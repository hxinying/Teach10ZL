package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.ExamInfo;
import com.teach.teach10zl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 任小龙 on 2020/10/24.
 */
public class ExamAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ExamInfo.ListInnerInfo> albums;

    public ExamAdapter(Context pContext, List<ExamInfo.ListInnerInfo> pAlbums) {
        mContext = pContext;
        albums = pAlbums;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.exam_adapter_layout, parent, false);
        return viewType == 0 ? new ViewHolder1(inflate) : new ViewHolder2(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
            List<ExamInfo.ListInnerInfo> temp = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                temp.add(albums.get(i));
            }
            holder1.mRecyclerView.setAdapter(new ExamTopAdapter(mContext, temp));
        } else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            List<ExamInfo.ListInnerInfo> temp = new ArrayList<>();
            for (int i = 6; i < albums.size(); i++) {
                temp.add(albums.get(i));
            }
            holder2.mRecyclerView.setAdapter(new ExamBottomAdapter(mContext, temp));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 0;
        else return 1;
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.adapter_recycle);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.adapter_recycle);
        }
    }
}
