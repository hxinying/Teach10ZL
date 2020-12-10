package com.teach.teach10zl.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.VipBannerAndLiveInfo;
import com.teach.datalibrary.VipCommonInfo;
import com.teach.datalibrary.VipListInfo;
import com.teach.teach10zl.R;
import com.teach.teach10zl.view.customs.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 任小龙 on 2020/10/16.
 */
public class VipLargeAdapter extends RecyclerView.Adapter<VipLargeAdapter.ViewHolder> {
    private Activity mContext;
    private List<VipCommonInfo> mList;
    public LiveAdapter mLiveAdapter;
    private List<VipBannerAndLiveInfo.LiveVipListInfo> live = new ArrayList<>();

    public VipLargeAdapter(Activity pContext, List<VipCommonInfo> pList) {
        mContext = pContext;
        mList = pList;
        mLiveAdapter=new LiveAdapter(live,100);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.vip_large_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mBannerLayout.attachActivity(mContext);
        List<VipBannerAndLiveInfo.BannerVip> lunbotu = mList.get(position).lunbotu;
        List<String> bannerList = new ArrayList<>();
        for (VipBannerAndLiveInfo.BannerVip b : lunbotu) {
            bannerList.add(b.img);
        }
        holder.mBannerLayout.setViewUrls(bannerList);

        LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.horizontalRecycle.setLayoutManager(manager);
        List<VipBannerAndLiveInfo.LiveVipListInfo> live = mList.get(position).live;
        this.live.addAll(live);
        mLiveAdapter.notifyDataSetChanged();
        holder.horizontalRecycle.setAdapter(mLiveAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        holder.bottomRecycle.setLayoutManager(gridLayoutManager);
        List<VipListInfo.VipInnerList> list = mList.get(position).list;
        VipBottomRecyclerAdapter adapter = new VipBottomRecyclerAdapter(mContext, list);
        holder.bottomRecycle.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BannerLayout mBannerLayout;
        RecyclerView horizontalRecycle;
        RecyclerView bottomRecycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBannerLayout = itemView.findViewById(R.id.banner_vip);
            horizontalRecycle = itemView.findViewById(R.id.live_recycler);
            bottomRecycle = itemView.findViewById(R.id.bottom_recycler);
        }
    }
}
