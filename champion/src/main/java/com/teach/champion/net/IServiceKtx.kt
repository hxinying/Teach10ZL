package com.teach.champion.net

import com.teach.champion.bean.DemoInfo
import com.teach.champion.bean.YanzhengmaBean
import okhttp3.ResponseBody
import retrofit2.http.*
import java.io.InputStream

/**
 * Created by 任小龙 on 2020/11/13.
 */
interface IServiceKtx {
    @POST
    suspend fun get(@Url url:String): YanzhengmaBean

    @GET
    suspend fun getDemoInfo(@Url url: String,@QueryMap params : MutableMap<String,Any>) : DemoInfo

    @GET
    suspend fun getVerifyBitmap(@Url url : String) : ResponseBody
}