package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.MatchData;
import com.teach.teach10zl.R;
import com.yiyatech.utils.glide_transformation.GlideUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2020/11/17.
 */
public class MatchChildAdapter extends RecyclerView.Adapter<MatchChildAdapter.ViewHolder> {
    private Context mContext;
    private List<MatchData.Data.ItemData> mList;

    public MatchChildAdapter(Context pContext, List<MatchData.Data.ItemData> pList) {
        mContext = pContext;
        mList = pList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.match_child_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchData.Data.ItemData itemData = mList.get(position);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(new Date(Long.parseLong(itemData.time)));
        holder.matchTime.setText(time);
//        GlideUtil.loadImage(holder.teamALogo, itemData.leftIcon);
        GlideUtil.loadImage(holder.teamALogo, "https://cdn.sportnanoapi.com/football/team/d8ddbbdf082b5c469b4e1f9e998690dd.png");
//        GlideUtil.loadImage(holder.teamBLogo, itemData.rightIcon);
        GlideUtil.loadImage(holder.teamBLogo, "https://cdn.sportnanoapi.com/football/team/d8ddbbdf082b5c469b4e1f9e998690dd.png");
        holder.teamAName.setText(itemData.leftName);
        holder.teamBName.setText(itemData.rightName);
        holder.teamAScore.setText(itemData.leftScore);
        holder.teamBScore.setText(itemData.rightScore);
        if (itemData.status.equals("0")) {
            holder.status.setText("未开始");
        } else if (itemData.status.equals("1")) {
            holder.status.setText("直播中");
            holder.status.setTextColor(ContextCompat.getColor(mContext,R.color.appThemeRed));
            holder.status.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play_going,0,0,0);
        } else if (itemData.status.equals("2")) {
            holder.status.setText("已结束");
            holder.status.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play_over,0,0,0);
        }
        holder.line.setVisibility(position != mList.size()-1 ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.match_time)
        TextView matchTime;
        @BindView(R.id.teamA_logo)
        ImageView teamALogo;
        @BindView(R.id.teamA_name)
        TextView teamAName;
        @BindView(R.id.teamB_logo)
        ImageView teamBLogo;
        @BindView(R.id.teamB_name)
        TextView teamBName;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.teamA_score)
        TextView teamAScore;
        @BindView(R.id.teamB_score)
        TextView teamBScore;
        @BindView(R.id.bottom_line)
        View line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
