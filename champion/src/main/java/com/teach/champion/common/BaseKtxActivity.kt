package com.teach.champion.common

import android.os.Bundle
import com.teach.frame10.frame.BaseActivity

/**
 * Created by 任小龙 on 2020/11/26.
 */
abstract class BaseKtxActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    abstract fun initView()

    abstract fun initData()
}