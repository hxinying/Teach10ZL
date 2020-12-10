package com.teach.champion.view.fragment

import android.net.Uri
import androidx.recyclerview.widget.GridLayoutManager
import com.teach.champion.R
import com.teach.champion.adapter.GetPicKtxAdapter
import com.teach.champion.common.BaseKtxFragment
import com.teach.frame10.frame.FrameApplication
import kotlinx.android.synthetic.main.fragment_answer_question.*
import org.devio.takephoto.model.CropOptions
import org.devio.takephoto.model.TResult
import razerdp.design.SlideFromBottomPhotoPopup
import java.io.File

class AnswerQuestionFragment : BaseKtxFragment(), GetPicKtxAdapter.OnPicItemClickListener, SlideFromBottomPhotoPopup.BottomPopClick {

    private lateinit var mAdapter: GetPicKtxAdapter
    private var mList = mutableListOf<String>()
    override fun initLayout(): Int = R.layout.fragment_answer_question

    override fun initView() {
        picRecycleView.layoutManager = GridLayoutManager(context, 3)
        mList.add("+")
        mAdapter = GetPicKtxAdapter(mList, requireContext())
        picRecycleView.adapter = mAdapter
        mAdapter.setOnPicItemClickListener(this)
    }

    override fun onItemClickListener(pos: Int, type: Int) {
        when (type) {
            mAdapter.imageType -> showToast("放大")
            mAdapter.addType -> showPop()
        }
    }

    private var photoPop: SlideFromBottomPhotoPopup? = null
    private fun showPop() {
        if (photoPop == null) {
            photoPop = SlideFromBottomPhotoPopup(activity)
            photoPop!!.setBottomClickListener(this)
        }
        photoPop!!.showPopupWindow()
    }

    override fun takePhotoClick(pos: Int) {
        when (pos) {
            SlideFromBottomPhotoPopup.CAMERA -> {
                takePhoto.onPickFromCaptureWithCrop(getUri(), getOption())
            }

            SlideFromBottomPhotoPopup.CAPTURE -> {
                takePhoto.onPickMultipleWithCrop(7 - mList.size, getOption())
            }
        }
        photoPop!!.dismiss()
    }

    override fun takeSuccess(result: TResult?) {
        super.takeSuccess(result)
        result?.images?.forEach {
            mList.add(0,if (!it.compressPath.isNullOrBlank()) it.compressPath else it.originalPath)
            mAdapter.notifyDataSetChanged()
        }
    }

    private fun getOption(): CropOptions? {
        return CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create()
    }


    private fun getUri(): Uri? {
        var mFile = File(FrameApplication.CACHE_PATH, "teach10" + System.currentTimeMillis() + ".png")
        if (!mFile.parentFile.exists()) {
            mFile.parentFile.mkdirs()
        }
        return Uri.fromFile(mFile)
    }
}
