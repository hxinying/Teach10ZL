package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.LessonChapterEntity;
import com.teach.teach10zl.R;
import com.teach.teach10zl.interfaces.OnRecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 任小龙 on 2020/11/6.
 */
public class CourseListGroupAdapter extends RecyclerView.Adapter<CourseListGroupAdapter.ViewHolder> {
    private Context mContext;
    private List<LessonChapterEntity> mGroupList;
    private List<String> mExpandList;

    public CourseListGroupAdapter(Context pContext, List<LessonChapterEntity> pGroupList, List<String> pExpandList) {
        mContext = pContext;
        mGroupList = pGroupList;
        mExpandList = pExpandList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_group_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LessonChapterEntity entity = mGroupList.get(position);
        holder.groupName.setText(entity.getCatalogueName());
        holder.ivCollapsed.setImageResource(mExpandList.contains(entity.getCatalogueName()) ? R.drawable.ic_lesson_collapsed : R.drawable.ic_lesson_expand);
        holder.groupChildRecycle.setVisibility(mExpandList.contains(entity.getCatalogueName()) ? View.VISIBLE : View.GONE);
        holder.groupChildRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        CourseListChildAdapter childAdapter = new CourseListChildAdapter(mContext, entity.getPartList());
        childAdapter.setOnRecyclerItemClick(pos -> {
               int childClickPos = (int) pos[0];
               int clickType = (int) pos[1];
               if (mOnRecyclerItemClickListener != null){
                   mOnRecyclerItemClickListener.onItemClick(position,childClickPos,clickType);
               }
        });
        holder.groupChildRecycle.setAdapter(childAdapter);
        holder.groupName.setOnClickListener(v -> {
            if (mExpandList.contains(entity.getCatalogueName())) {
                mExpandList.remove(entity.getCatalogueName());
            } else mExpandList.add(entity.getCatalogueName());
            notifyDataSetChanged();
        });
    }

    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener pOnRecyclerItemClickListener) {
        this.mOnRecyclerItemClickListener = pOnRecyclerItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.groupName)
        TextView groupName;
        @BindView(R.id.iv_collapsed)
        ImageView ivCollapsed;
        @BindView(R.id.groupChildRecycle)
        RecyclerView groupChildRecycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
