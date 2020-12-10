package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.TableInfo;
import com.teach.teach10zl.R;

import java.util.List;

/**
 * Created by 任小龙 on 2020/11/1.
 */
public class TableDataAdapter extends RecyclerView.Adapter<TableDataAdapter.ViewHolder> {
    private List<TableInfo> mList;
    private Context mContext;
    private int which;

    public TableDataAdapter(List<TableInfo> pList, Context pContext,int which) {
        mList = pList;
        mContext = pContext;
        this.which = which;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.table_data_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dataRecycle.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        });
        holder.dataRecycle.setAdapter(new TableDataInnerAdapter(mList.get(position).tableList, mContext,position));
        holder.dataRecycle.setNestedScrollingEnabled(false);
        holder.dataRecycle.setHasFixedSize(true);
        holder.dataRecycle.setFocusable(false);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView dataRecycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dataRecycle = itemView.findViewById(R.id.province_data_recycle);
        }
    }
}
