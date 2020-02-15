package com.example.apaga.ui.base

interface MvpPresenter<in T> {
    fun subscribe()
    fun unsubscribe()
    fun attach(view: T)
}