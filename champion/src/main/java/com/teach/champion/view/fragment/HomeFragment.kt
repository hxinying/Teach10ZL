package com.teach.champion.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.teach.champion.R
import com.teach.champion.view.activity.MainActivity
import com.teach.frame10.frame.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    lateinit var homeController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeController = Navigation.findNavController(activity as MainActivity, R.id.homeController)
        homeController.addOnDestinationChangedListener { _, destination, _ ->
            val lable = destination.label.toString()
            showLog(lable)
        }
        initBottomView()
    }

    private fun initBottomView() {
        var selectedDrawable = mutableListOf(R.drawable.class_room_blue,R.drawable.answer_blue,R.drawable.action_blue,R.drawable.mine_blue)
        var unSelectedDrawable = mutableListOf(R.drawable.class_room_gray,R.drawable.anwser_gray,R.drawable.action_gray,R.drawable.mine_gray)
        var content = mutableListOf("课堂","答疑","活动","我的")
        bottomTab.setResource(selectedDrawable,unSelectedDrawable,content)
        bottomTab.setOnRecyclerItemClickListener {
            var index = it[0]
            when(index){
                1->homeController.navigate(R.id.class_room_fragment)
                2->homeController.navigate(R.id.answer_question_fragment)
                3->homeController.navigate(R.id.action_fragment)
                4->homeController.navigate(R.id.mine_fragment)
            }
        }
    }
}
