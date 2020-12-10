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

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 任小龙 on 2020/11/1.
 */
public class TableDataInnerAdapter extends RecyclerView.Adapter<TableDataInnerAdapter.ViewHolder> {
    private List<TableInfo.TableContent> mList;
    private Context mContext;
    private int fatherPos;

    public TableDataInnerAdapter(List<TableInfo.TableContent> tableList, Context pContext, int fatherPos) {
        mList = tableList;
        mContext = pContext;
        this.fatherPos = fatherPos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.table_data_inner_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.innerText.setText(String.valueOf(mList.get(position).tabData));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView innerText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            innerText = itemView.findViewById(R.id.inner_text);
        }
    }
}
