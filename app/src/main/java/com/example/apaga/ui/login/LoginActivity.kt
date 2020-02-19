package com.example.apaga.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.di.component.AppComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.home.HomeActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun setupComponent(appComponent: AppComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }

    @Inject
    lateinit var presenter: LoginContract.Presenter
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: Button
    private lateinit var facebookRegistration: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.attach(this)
        actionWithXmlViews()
    }

    override fun onStart() {
        presenter.subscribe()
        super.onStart()
    }

    override fun onPause() {
        presenter.unsubscribe()
        super.onPause()
    }

    override fun openRegistrationEmailFragment() {

    }

    override fun openRegistrationFacebookActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openHomeActivity() {
        startActivity(Intent(this,HomeActivity::class.java))
    }

    private fun actionWithXmlViews(){
        findViewIds()
        setButtonsClickListener()
    }
    private fun findViewIds() {
        email = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        login = findViewById(R.id.btn_login)
        emailRegistration = findViewById(R.id.btn_email)
        facebookRegistration = findViewById(R.id.btn_facebook)
    }

    private fun setButtonsClickListener() {
        login.setOnClickListener {
            presenter.login(email.text.toString(),password.text.toString())
        }
        emailRegistration.setOnClickListener {

        }
        facebookRegistration.setOnClickListener{

        }
    }
}
