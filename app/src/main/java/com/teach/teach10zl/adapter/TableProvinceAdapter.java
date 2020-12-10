package com.teach.teach10zl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.teach.datalibrary.TableInfo;
import com.teach.teach10zl.R;

import java.util.List;

/**
 * Created by 任小龙 on 2020/11/1.
 */
public class TableProvinceAdapter extends RecyclerView.Adapter<TableProvinceAdapter.ViewHolder> {
    private List<TableInfo> mList;
    private Context mContext;

    public TableProvinceAdapter(List<TableInfo> pList, Context pContext) {
        mList = pList;
        mContext = pContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.table_province_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.provinceText.setText(mList.get(position).province );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView provinceText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            provinceText = itemView.findViewById(R.id.province_text);
        }
    }
}
