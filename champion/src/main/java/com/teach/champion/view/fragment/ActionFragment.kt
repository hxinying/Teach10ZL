package com.teach.champion.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.teach.champion.R
import org.jetbrains.anko.toast

class ActionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        requireActivity().toast("third")
        return inflater.inflate(R.layout.fragment_action, container, false)
    }

}
