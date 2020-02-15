package com.example.apaga.ui.base

interface BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View

    interface  Model

}