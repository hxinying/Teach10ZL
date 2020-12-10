package com.teach.champion.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teach.champion.R
import com.teach.champion.common.BaseKtxAdapter
import com.yiyatech.utils.glide_transformation.GlideUtil
import kotlinx.android.synthetic.main.get_pic_adapter_layout.view.*

/**
 * Created by 任小龙 on 2020/11/25.
 */
class GetPicKtxAdapter(list : MutableList<String>, context: Context) : BaseKtxAdapter<String>(list,context) {

    val imageType  = 1
    val addType  = 2
    private var canClose = false
    override fun setLayoutId(type : Int): Int {
        return R.layout.get_pic_adapter_layout
    }

    override fun bindView(data: String, view: View, pos: Int,holder: RecyclerView.ViewHolder) {
        holder.setIsRecyclable(false)
        if (data != "+"){
            view.cancel_image.visibility = if (canClose) View.VISIBLE else View.INVISIBLE
            GlideUtil.loadImage(view.picImage,data)

            if(listener != null) {
                view.picImage.run {
                    this.setOnClickListener {
                        listener!!.onItemClickListener(pos,imageType)
                    }
                    this.setOnLongClickListener {
                        canClose = !canClose
                        notifyDataSetChanged()
                        true
                    }
                }
                view.cancel_image.setOnClickListener {
                    mListData.removeAt(pos)
                    notifyDataSetChanged()
                }
            }
        } else{
            GlideUtil.loadImage(view.picImage,R.drawable.default_pic)
            if (listener != null){
                view.picImage.setOnClickListener {
                    listener!!.onItemClickListener(pos,addType)
                }
            }
            view.visibility = if (mListData.size<7)View.VISIBLE else View.GONE
        }
    }

    private var listener: OnPicItemClickListener? = null

    fun setOnPicItemClickListener(listener: OnPicItemClickListener) {
        this.listener = listener
    }

    interface OnPicItemClickListener {
        fun onItemClickListener(pos: Int,type : Int)
    }
}