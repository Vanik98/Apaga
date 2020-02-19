package com.example.apaga.ui.payment

class PaymentPresenter : PaymentContract.Presenter {
    lateinit var view : PaymentContract.View
    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: PaymentContract.View) {
        this.view = view
    }
}