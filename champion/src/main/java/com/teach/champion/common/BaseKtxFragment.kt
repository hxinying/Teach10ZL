package com.teach.champion.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teach.champion.R
import com.teach.frame10.frame.BaseFragment

/**
 * Created by 任小龙 on 2020/11/25.
 */
abstract class BaseKtxFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    abstract fun initLayout(): Int
    abstract fun initView()
    open fun initData() {}
}