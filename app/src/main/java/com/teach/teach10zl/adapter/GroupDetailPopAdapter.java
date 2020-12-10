package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.GroupDetailEntity;
import com.teach.teach10zl.R;
import com.teach.teach10zl.constants.Constant;
import com.teach.teach10zl.interfaces.OnRecyclerItemClickListener;

import java.util.List;

/**
 * Created by 任小龙 on 2020/6/17.
 */
public class GroupDetailPopAdapter extends RecyclerView.Adapter<GroupDetailPopAdapter.ViewHolder> {
    private Context mContext;
    private List<GroupDetailEntity.Tag.SelectsBean> mPopData;

    public GroupDetailPopAdapter(Context pContext, List<GroupDetailEntity.Tag.SelectsBean> pPopData) {
        mContext = pContext;
        mPopData = pPopData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.group_detail_pop_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GroupDetailEntity.Tag.SelectsBean bean = mPopData.get(position);
        holder.popTab.setText(bean.getName());
        holder.popTab.setTextColor(ContextCompat.getColor(mContext,bean.getOn() == 1 ? R.color.white : R.color.black));
        holder.popTab.setBackground(ContextCompat.getDrawable(mContext, bean.getOn() == 1 ? R.drawable.shape_group_pop_item_bg : R.drawable.shape_group_pop_item_bg_unselected));
        holder.popTab.setOnClickListener(v -> {
            if (mOnRecyclerItemClick != null) mOnRecyclerItemClick.onItemClick(position, Constant.POP);
        });
    }

    private OnRecyclerItemClickListener mOnRecyclerItemClick;

    public void setOnRecyclerItemClick(OnRecyclerItemClickListener pOnRecyclerItemClick) {
        mOnRecyclerItemClick = pOnRecyclerItemClick;
    }

    @Override
    public int getItemCount() {
        return mPopData != null ? mPopData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView popTab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popTab = itemView.findViewById(R.id.tabPopItem);
        }
    }
}