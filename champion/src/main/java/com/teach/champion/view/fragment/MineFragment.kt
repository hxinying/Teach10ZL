package com.teach.champion.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.teach.champion.R
import com.teach.frame10.frame.BaseFragment

class MineFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        showToast("forth")
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

}
