package com.teach.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.teach.frame10.constants.ArouterConstant
import kotlinx.android.synthetic.main.activity_router.*

@Route(path = ArouterConstant.ROUTER)
class RouterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)
        routerText.setOnClickListener {
            ARouter.getInstance().build(ArouterConstant.XLOGIN).navigation()
        }

        routerText.setOnLongClickListener {
            ARouter.getInstance().build(ArouterConstant.HOME).navigation()
            true
        }
    }
}
