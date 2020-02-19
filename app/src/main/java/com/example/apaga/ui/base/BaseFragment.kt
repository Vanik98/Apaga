package com.example.apaga.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.apaga.MvpApp
import com.example.apaga.di.component.AppComponent
import com.example.apaga.di.component.FragmentComponent

abstract class BaseFragment : Fragment(){
    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupComponent()

    }
    abstract fun setupComponent()
}