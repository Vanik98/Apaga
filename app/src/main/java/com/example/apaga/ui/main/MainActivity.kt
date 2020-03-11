package com.example.apaga.ui.main

import android.content.Intent
import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        presenter.onAttach(this)
        actionWithXmlViews()
    }

    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
//        presenter.accessTokenTracker()
    }

    private fun actionWithXmlViews() {
        findViewIds()
        setButtonsClickListener()
    }

    private fun setButtonsClickListener() {
        print("")
    }

    private fun setViewParameters() {
        print("")
    }

    private fun findViewIds() {
        print("")
    }



}


