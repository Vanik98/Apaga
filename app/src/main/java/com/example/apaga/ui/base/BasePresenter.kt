package com.example.apaga.ui.base

import com.example.apaga.data.DataManager
import javax.inject.Inject

open class BasePresenter<V : MvpView> @Inject constructor(val dataManager: DataManager) : MvpPresenter<V> {
    var mvpView: V? = null
        private set

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        mvpView = null
    }

    private val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    override fun setUserAsLoggedOut() {
        dataManager.setAccessToken(null)
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(MvpView) before" +
            " requesting data to the Presenter")

    companion object {
        private const val TAG = "BasePresenter"
    }

}