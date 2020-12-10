package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.DataListInfo;
import com.teach.teach10zl.R;
import com.teach.teach10zl.interfaces.OnRecyclerItemClickListener;
import com.teach.teach10zl.view.customs.RoundOrCircleImage;
import com.yiyatech.utils.glide_transformation.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2020/10/12.
 */
public class DataGroupListAdapter extends RecyclerView.Adapter<DataGroupListAdapter.ViewHolder> {

    private Context mContext;
    private List<DataListInfo> mList;
    public final int ITEM = 1, FOCUS = 2;

    public DataGroupListAdapter(Context pContext, List<DataListInfo> pList) {
        mContext = pContext;
        mList = pList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.data_group_list_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataListInfo info = mList.get(position);
        GlideUtil.loadImage(holder.roundCornerPhoto, info.avatar);
        holder.title.setText(info.group_name);
        holder.focusCount.setText(info.member_num + "关注");
        holder.desc.setText(info.introduce);
        holder.focusButton.setOnClickListener(v -> {
            if (mOnRecyclerItemClickListener != null)
                mOnRecyclerItemClickListener.onItemClick(position, FOCUS);
        });
        holder.itemView.setOnClickListener(v -> {
            if (mOnRecyclerItemClickListener != null)
                mOnRecyclerItemClickListener.onItemClick(position, ITEM);
        });
        if (info.is_ftop != 1){
            holder.focusButton.setTextColor(ContextCompat.getColor(mContext,R.color.appThemeRed));
            holder.focusButton.setText("+关注");
            holder.focusButton.setBackgroundResource(R.drawable.none_focus_shape_bg);
        } else {
            holder.focusButton.setTextColor(ContextCompat.getColor(mContext,R.color.font_color_light));
            holder.focusButton.setText("已关注");
            holder.focusButton.setBackgroundResource(R.drawable.focus_shape_bg);
        }
    }

    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener pOnRecyclerItemClickListener) {
        mOnRecyclerItemClickListener = pOnRecyclerItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.round_corner_photo)
        RoundOrCircleImage roundCornerPhoto;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.focus_count)
        TextView focusCount;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.focus_button)
        TextView focusButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
