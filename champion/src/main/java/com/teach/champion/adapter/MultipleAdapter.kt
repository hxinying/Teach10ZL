package com.teach.champion.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teach.champion.R
import com.teach.champion.bean.DemoInfo
import com.teach.champion.common.BaseKtxAdapter
import com.yiyatech.utils.glide_transformation.GlideUtil
import kotlinx.android.synthetic.main.first_layout.view.*
import kotlinx.android.synthetic.main.second_layout.view.*

/**
 * Created by 任小龙 on 2020/11/26.
 */
class MultipleAdapter(list : MutableList<DemoInfo.DemoInfoDatas>,context: Context) : BaseKtxAdapter<DemoInfo.DemoInfoDatas>(list,context) {

    override fun setLayoutId(viewType: Int): Int = if (viewType == 0) R.layout.first_layout else R.layout.second_layout

    override fun getItemViewType(position: Int): Int {
        mListData[position].id.run {
            return if (this.substring(this.length-1).toInt() > 3) 0 else 1
        }
    }

    override fun bindView(data: DemoInfo.DemoInfoDatas, view: View, pos: Int, holder: RecyclerView.ViewHolder) {
        if (getItemViewType(pos)==0){
            view.topText.text=data.title
            GlideUtil.loadImage(view.bottomImage,data.thumbnail)
        } else{
            GlideUtil.loadImage(view.leftImage,data.thumbnail)
            view.rightText.text = data.title
        }
    }
}