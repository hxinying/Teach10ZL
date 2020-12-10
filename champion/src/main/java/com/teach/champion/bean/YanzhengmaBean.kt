package com.teach.champion.bean

data class YanzhengmaBean(
    var status: Int,
    var message: String,
    var data: DataBean
) {
    data class DataBean(
        var img: String,
        var capToken: String
    )
}