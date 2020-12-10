package com.teach.teach10zl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.DataListInfo;
import com.teach.teach10zl.R;
import com.yiyatech.utils.glide_transformation.GlideUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2020/10/12.
 */
public class NewBestAdapter extends RecyclerView.Adapter<NewBestAdapter.ViewHolder> {

    private List<DataListInfo> mList;

    public NewBestAdapter(List<DataListInfo> pList) {
        mList = pList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.small_image_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataListInfo info = mList.get(position);
        holder.title.setText(info.title);
        holder.scanNum.setText(info.view_num + "人浏览");
        holder.followNum.setText(info.reply_num + "人跟帖");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = formatter.format(Long.parseLong(info.create_time));
        holder.date.setText(format1);
        GlideUtil.loadImage(holder.rightImage, info.pic);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.right_image)
        ImageView rightImage;
        @BindView(R.id.scan_num)
        TextView scanNum;
        @BindView(R.id.follow_num)
        TextView followNum;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.right_image_itemView)
        ConstraintLayout rightImageItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
