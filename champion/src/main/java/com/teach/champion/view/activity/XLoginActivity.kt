package com.teach.champion.view.activity

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.teach.champion.R
import com.teach.champion.adapter.FirstKotlinDemoKtxAdapter
import com.teach.champion.bean.DemoInfo
import com.teach.champion.common.BaseKtxActivity
import com.teach.champion.constants.ApiConstant
import com.teach.champion.databinding.ActivityXLoginBinding
import com.teach.champion.net.NetManagerKtx
import com.teach.champion.viewModel.XLoginViewModel
import com.teach.frame10.constants.ArouterConstant
import kotlinx.android.synthetic.main.activity_x_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Route(path = ArouterConstant.XLOGIN)
class XLoginActivity : BaseKtxActivity() {
    private var list: MutableList<DemoInfo.DemoInfoDatas> = mutableListOf()
    private lateinit var adapter: FirstKotlinDemoKtxAdapter
    private lateinit var contentView: ActivityXLoginBinding
    override fun initView() {
        contentView = DataBindingUtil.setContentView(this, R.layout.activity_x_login)
        contentView.viewModel = XLoginViewModel()
        recyclerView_demo.layoutManager = LinearLayoutManager(this)
        adapter = FirstKotlinDemoKtxAdapter(list, this)
        recyclerView_demo.adapter = adapter
    }
    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            contentView.verify = getVerifyImage()
            getDemoInfo().run {
                contentView.listData = this
                list.addAll(this.datas)
                adapter.notifyDataSetChanged()
            }
            contentView.bitmap = getVerifyBitmap()
        }
    }

    private suspend fun getDemoInfo() = withContext(Dispatchers.IO) {
        var map = mutableMapOf<String, Any>("c" to "api", "a" to "getList", "page_id" to 0)
        NetManagerKtx.managerKtx.iServiceKtx.getDemoInfo(ApiConstant.DEMO_LIST, map)
    }

    private suspend fun getVerifyImage() = withContext(Dispatchers.IO) {
        NetManagerKtx.managerKtx.iServiceKtx.get(ApiConstant.VERIFY_IMAGE)
    }

    private suspend fun getVerifyBitmap() = withContext(Dispatchers.IO) {
        NetManagerKtx.managerKtx.iServiceKtx.getVerifyBitmap(ApiConstant.VERIFY_BITMAP)
    }
}