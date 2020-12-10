package com.teach.champion.net

import com.teach.frame10.constants.UrlConstantKtx
import com.teach.frame10.frame.ControlTimeInterceptor
import com.teach.frame10.frame.MyProxySelector
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.Proxy
import java.net.ProxySelector
import java.net.SocketAddress
import java.net.URI
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by 任小龙 on 2020/11/13.
 */
class NetManagerKtx private constructor() {
    var iServiceKtx: IServiceKtx

    companion object {
        val managerKtx: NetManagerKtx by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { NetManagerKtx() }
    }

    init {
        iServiceKtx = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UrlConstantKtx.BASE_URL).client(initClient(5)).build().create(IServiceKtx::class.java)
    }

    private fun initClient(time: Long) = OkHttpClient.Builder().addInterceptor(initLogInterceptor()).addInterceptor(ControlTimeInterceptor(0))
        .connectTimeout(time, TimeUnit.SECONDS).readTimeout(time, TimeUnit.SECONDS).writeTimeout(time, TimeUnit.SECONDS)
        .proxySelector(MyProxySelector()).build()

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}