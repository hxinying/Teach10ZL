package com.teach.champion.viewModel

import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.teach.champion.view.activity.MainActivity
import com.teach.frame10.constants.ArouterConstant
import com.yiyatech.utils.glide_transformation.GlideUtil
import okhttp3.ResponseBody
import java.io.InputStream

/**
 * Created by 任小龙 on 2020/11/25.
 */
class XLoginViewModel {
    fun textClick(view: View) {
        view.context.startActivity(Intent(view.context, MainActivity::class.java))
    }

    fun imageClick(view: View){
        ARouter.getInstance().build(ArouterConstant.ROUTER).navigation()
    }

    companion object{
        @BindingAdapter("base64Content")
        @JvmStatic
        fun base(pImageView: ImageView?, content: String?) {
            if (!content.isNullOrBlank()) {
                val decode = Base64.decode(content, Base64.DEFAULT)
                GlideUtil.loadImage(pImageView, BitmapFactory.decodeByteArray(decode, 0, decode.size))
            }
        }

        @BindingAdapter("bitmap")
        @JvmStatic
        fun bitmap(pImageView: ImageView?, content: ResponseBody?) {
            if (content != null) {
                val bitmap = BitmapFactory.decodeStream(content.byteStream())
                GlideUtil.loadImage(pImageView, bitmap)
            }
        }
    }
}