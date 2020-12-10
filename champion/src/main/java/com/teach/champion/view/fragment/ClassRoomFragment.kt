package com.teach.champion.view.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.teach.champion.R
import com.teach.champion.adapter.MultipleAdapter
import com.teach.champion.bean.DemoInfo
import com.teach.champion.common.BaseKtxFragment
import com.teach.champion.constants.ApiConstant
import com.teach.champion.net.NetManagerKtx
import kotlinx.android.synthetic.main.fragment_class_room.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ClassRoomFragment : BaseKtxFragment() {

    private var list = mutableListOf<DemoInfo.DemoInfoDatas>()
    private lateinit var adapter: MultipleAdapter

    override fun initLayout(): Int {
        return R.layout.fragment_class_room
    }

    override fun initView() {
        multipleRecycle.layoutManager = LinearLayoutManager(context)
        adapter = MultipleAdapter(list, requireContext())
        multipleRecycle.adapter = adapter
    }

    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            list.addAll(getListData().datas)
            adapter.notifyDataSetChanged()
        }
    }

    private suspend fun getListData() = withContext(Dispatchers.IO) {
        var map = mutableMapOf<String, Any>("c" to "api", "a" to "getList", "page_id" to 0)
        NetManagerKtx.managerKtx.iServiceKtx.getDemoInfo(ApiConstant.DEMO_LIST, map)
    }
}
