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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2020/6/16.
 */
public class GroupDetailCenterTabAdapter extends RecyclerView.Adapter<GroupDetailCenterTabAdapter.ViewHolder> {

    private Context mContext;
    private List<GroupDetailEntity.Tag> mTabListData;

    public GroupDetailCenterTabAdapter(Context pContext, List<GroupDetailEntity.Tag> pTabListData) {
        mContext = pContext;
        mTabListData = pTabListData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.group_detail_tab_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        GroupDetailEntity.Tag tag = mTabListData.get(position);
        holder.tagContent.setText(tag.getTag_name());
        holder.tagContent.setTextColor(ContextCompat.getColor(mContext,tag.isExpand ? R.color.appThemeRed : R.color.font_color_light));
        holder.fallsView.setVisibility(tag.isExpand ? View.VISIBLE : View.GONE);
        holder.tagContent.setCompoundDrawablesWithIntrinsicBounds(0,0,tag.isExpand ? R.drawable.ic_menu_arrow_up_red :R.drawable.ic_menu_arrow_down_gray ,0);
        if (tag.getOn() == 1){
            List<GroupDetailEntity.Tag.SelectsBean> popList = tag.getSelects();
            for (GroupDetailEntity.Tag.SelectsBean data : popList) {
                if (data.getOn() == 1){
                    holder.tagContent.setText(data.getName());
                    holder.tagContent.setTextColor(ContextCompat.getColor(mContext,R.color.appThemeRed));
                    holder.tagContent.setCompoundDrawablesWithIntrinsicBounds(0,0,tag.isExpand ? R.drawable.ic_menu_arrow_up_red : R.drawable.ic_menu_arrow_down_red,0);
                    holder.tagContent.setBackgroundResource(tag.isExpand ? R.drawable.group_tab_bg : R.drawable.group_tab_bg_has_selected_content);
                    break;
                }
            }
        }

        holder.tagContent.setOnClickListener(v -> {
            tag.isExpand = true;
            notifyDataSetChanged();
            if (mOnRecyclerItemClick != null) mOnRecyclerItemClick.onItemClick(position, Constant.TAB);
        });
    }

    private OnRecyclerItemClickListener mOnRecyclerItemClick;

    public void setOnRecyclerItemClick(OnRecyclerItemClickListener pOnRecyclerItemClick) {
        mOnRecyclerItemClick = pOnRecyclerItemClick;
    }

    @Override
    public int getItemCount() {
        return mTabListData != null ? mTabListData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.falls_view)
        View fallsView;
        @BindView(R.id.tagContent)
        TextView tagContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
