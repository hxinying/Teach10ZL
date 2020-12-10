package com.teach.champion.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by 任小龙 on 2020/11/23.
 */
abstract class BaseKtxAdapter<集合内对象的类型>(list: MutableList<集合内对象的类型>, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mListData: MutableList<集合内对象的类型> = list
    var mContext: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommonViewHolder(LayoutInflater.from(mContext).inflate(setLayoutId(viewType), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mListData[position].run {
            holder.itemView.also {
                bindView(this, it, position,holder)
                if (listener != null) {
                    it.setOnClickListener {
                        listener!!.onClickListener(position)
                    }
                    it.setOnLongClickListener {
                        listener!!.onLongClickListener(position)
                        true
                    }
                }
            }
        }
    }

    abstract fun bindView(data: 集合内对象的类型, view: View, pos: Int,holder: RecyclerView.ViewHolder)

    override fun getItemCount(): Int {
        return mListData.size
    }

    abstract fun setLayoutId(viewType: Int): Int

    private var listener: OnSingleItemClickListener? = null

    fun setOnSingleItemClickListener(listener: OnSingleItemClickListener) {
        this.listener = listener
    }

    interface OnSingleItemClickListener {
        fun onClickListener(pos: Int)
        fun onLongClickListener(pos: Int) {

        }
    }
}