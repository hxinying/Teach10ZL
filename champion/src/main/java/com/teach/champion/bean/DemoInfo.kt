package com.teach.champion.bean

/**
 * Created by 任小龙 on 2020/11/23.
 */
data class DemoInfo(val status : String,var code : Int,var datas : MutableList<DemoInfoDatas>) {
    data class DemoInfoDatas(var id : String,var thumbnail : String,var title : String)
}