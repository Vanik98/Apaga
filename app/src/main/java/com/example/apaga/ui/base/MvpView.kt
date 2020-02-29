package com.example.apaga.ui.base

import androidx.annotation.StringRes

interface MvpView {
    fun showLoading()
    fun hideLoading()
    fun openActivityOnTokenExpire()
    fun onError(@StringRes resId: Int)
    fun onError(message: String)
    fun showMessage(message: String)
    fun showMessage(@StringRes resId: Int)
    fun isNetworkConnected(): Boolean
    fun hideKeyboard()
}