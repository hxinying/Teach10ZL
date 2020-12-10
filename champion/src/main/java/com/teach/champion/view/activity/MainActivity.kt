package com.teach.champion.view.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.teach.champion.R
import com.teach.frame10.constants.ArouterConstant
import com.teach.frame10.frame.BaseActivity

/**
 * Created by 任小龙 on 2020/11/24.
 */
@Route(path = ArouterConstant.XMAIN)
class MainActivity : BaseActivity(), NavController.OnDestinationChangedListener {
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        navController = Navigation.findNavController(this, R.id.projectNavFragment)
        navController.addOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        showLog(destination.label.toString())
    }
}