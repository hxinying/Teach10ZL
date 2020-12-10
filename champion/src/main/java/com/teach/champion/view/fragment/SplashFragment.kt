package com.teach.champion.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.teach.champion.R
import com.teach.champion.view.activity.MainActivity
import com.teach.frame10.frame.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val int = if (arguments != null)arguments!!.getString("home")else ""
        showLog(int!!)
        splashText.setOnClickListener {
            var mainActivity : MainActivity = activity as MainActivity
            var bundle = Bundle()
            bundle.putString("splash","splash")
            mainActivity.navController.navigate(R.id.splash_to_home,bundle)
        }
    }

}
