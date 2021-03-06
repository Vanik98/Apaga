package com.example.apaga.ui.base

interface SubMvpView : MvpView {
    fun setUp()
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    fun attachParentMvpView(mvpView: MvpView?)
}