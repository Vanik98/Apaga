package com.example.apaga.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.home.HomeActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {


    @Inject
    lateinit var presenter: MainContract.Presenter
//    @Inject
//    lateinit var dialogUtils: DialogUtils
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: Button
    private lateinit var facebookRegistration: LoginButton
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        presenter.onAttach(this)
        callbackManager = CallbackManager.Factory.create()
        actionWithXmlViews()
    }

    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRegistrationEmailFragment() {

    }

    override fun openRegistrationFacebookActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openHomeActivity() {
//        dialogUtils.showProgressBar(this)
//        dialogUtils.showConfirmationDialog(this,null,"asdasd",null,null)
        startActivity(Intent(this, HomeActivity::class.java))
    }


    private fun actionWithXmlViews() {
        findViewIds()
        setViewParameters()
        setButtonsClickListener()
    }

    private fun setViewParameters(){
        facebookRegistration.setReadPermissions(listOf("email", "public_profile"))
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
            presenter.loginWithEmail(email.text.toString(), password.text.toString())
        }
        emailRegistration.setOnClickListener {

        }
        facebookRegistration.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
        presenter.accessTokenTracker()
    }

}
