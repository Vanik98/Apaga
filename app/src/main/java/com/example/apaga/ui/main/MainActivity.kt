package com.example.apaga.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.login.LoginFragment
import javax.inject.Inject
import kotlin.math.log

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter
    lateinit var background: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        presenter.onAttach(this)
        setUp()
    }


    override fun findViewsById() {
        background = findViewById(R.id.main_im_apaga_background)
    }

    override fun setViewsOptions() {
        background.visibility = View.INVISIBLE
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
//        presenter.accessTokenTracker()
    }


}


