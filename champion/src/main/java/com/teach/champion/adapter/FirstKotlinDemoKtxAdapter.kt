package com.teach.champion.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teach.champion.R
import com.teach.champion.bean.DemoInfo
import com.teach.champion.common.BaseKtxAdapter
import com.yiyatech.utils.glide_transformation.GlideUtil
import kotlinx.android.synthetic.main.first_kotlin_adapter_layout.view.*

/**
 * Created by 任小龙 on 2020/11/23.
 */

class FirstKotlinDemoKtxAdapter(list: MutableList<DemoInfo.DemoInfoDatas>, context: Context) : BaseKtxAdapter<DemoInfo.DemoInfoDatas>(list, context) {

    override fun setLayoutId(v : Int): Int {
        return R.layout.first_kotlin_adapter_layout
    }

    override fun bindView(data: DemoInfo.DemoInfoDatas, view: View,pos : Int,holder: RecyclerView.ViewHolder) {
        GlideUtil.loadImage(view.left_image, data.thumbnail)
        view.title.text = data.title
    }
}