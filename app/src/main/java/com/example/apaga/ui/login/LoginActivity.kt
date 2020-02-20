package com.example.apaga.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions
import com.example.apaga.R
import com.example.apaga.data.db.model.User
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.di.component.AppComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.utils.DialogUtils
import com.facebook.*
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import kotlinx.android.synthetic.main.activity_login.view.*
import org.json.JSONObject
import java.util.*
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
    @Inject
    lateinit var dialogUtils: DialogUtils
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: Button
    private lateinit var facebookRegistration: LoginButton
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.attach(this)
        callbackManager = CallbackManager.Factory.create()
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
