package com.example.apaga.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter
    lateinit var background:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionWithViews()
    }

    override fun setUp() {
        activityComponent.inject(this)
        presenter.onAttach(this)
    }

    override fun findViewsById() {
        background = findViewById(R.id.main_im_apaga_background)
    }

    override fun setViewsOnClickListener() {

    }

    override fun setViewsOptions() {
        background.visibility = View.INVISIBLE
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
//        presenter.accessTokenTracker()
    }


    private fun setButtonsClickListener() {
        print("")
    }

}


