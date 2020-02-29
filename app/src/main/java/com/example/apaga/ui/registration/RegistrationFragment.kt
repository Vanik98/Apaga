package com.example.apaga.ui.registration

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RegistrationFragment : BaseFragment() {
    override fun setUp(view: View) {
        view.setOnClickListener{}
    }
    // TODO: Rename and change types of parameters


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }




}
