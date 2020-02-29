package com.example.apaga.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.example.apaga.R
import com.example.apaga.di.MainFragmentsTypeKey
import com.example.apaga.enums.MainFragmentsType
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.ui.main.MainActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import javax.inject.Inject
import javax.inject.Provider


class LoginFragment : BaseFragment(),LoginContract.View {

    @Inject
    lateinit var presenter:LoginContract.Presenter
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: Button
    private lateinit var facebookRegistration: LoginButton
    private lateinit var callbackManager: CallbackManager

    override fun setUp(view: View) {
        view.setOnClickListener{}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        callbackManager = CallbackManager.Factory.create()
        actionWithXmlViews(view)
        return view
    }
    private fun actionWithXmlViews(view: View) {
        findViewIds(view)
        setViewParameters()
        setButtonsClickListener()
    }

    private fun setViewParameters(){
        facebookRegistration.setReadPermissions(listOf("email", "public_profile"))
    }

    private fun findViewIds(view: View) {
        email = view.findViewById(R.id.et_email)
        password = view.findViewById(R.id.et_password)
        login = view.findViewById(R.id.btn_login)
        emailRegistration = view.findViewById(R.id.btn_email)
        facebookRegistration = view.findViewById(R.id.btn_facebook)
    }
//    @Inject lateinit var map : Map<MainFragmentsType, BaseFragment>

    private fun setButtonsClickListener() {
        login.setOnClickListener {
            presenter.loginWithEmail(email.text.toString(), password.text.toString())
        }
        emailRegistration.setOnClickListener {
//            (activity as MainActivity).replaceFragment(map.getValue(MainFragmentsType.REGISTRATION))
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

    override fun openRegistrationEmailFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRegistrationFacebookActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openHomeActivity() {
        //        dialogUtils.showProgressBar(this)
//        dialogUtils.showConfirmationDialog(this,null,"asdasd",null,null)
        startActivity(Intent(activity, HomeActivity::class.java))
    }
}

