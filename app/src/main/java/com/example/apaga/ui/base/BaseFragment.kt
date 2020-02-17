package com.example.apaga.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.apaga.MvpApp
import com.example.apaga.di.component.AppComponent

abstract class BaseFragment : Fragment(){
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
    abstract fun setupComponent(fragment: Fragment)
}