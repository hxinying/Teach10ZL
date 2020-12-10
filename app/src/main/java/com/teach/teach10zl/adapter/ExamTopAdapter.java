package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.ExamInfo;
import com.teach.teach10zl.R;
import com.teach.teach10zl.view.customs.RoundOrCircleImage;
import com.yiyatech.utils.glide_transformation.GlideUtil;

import java.util.List;

/**
 * Created by 任小龙 on 2020/10/24.
 */
public class ExamTopAdapter extends RecyclerView.Adapter<ExamTopAdapter.ViewHolder> {
    private Context mContext;
    private List<ExamInfo.ListInnerInfo> albums;

    public ExamTopAdapter(Context pContext, List<ExamInfo.ListInnerInfo> pAlbums) {
        mContext = pContext;
        albums = pAlbums;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.top_adapter_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GlideUtil.loadImage(holder.topImage,albums.get(position).image_ver);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundOrCircleImage topImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topImage = itemView.findViewById(R.id.top_image);
        }
    }
}
