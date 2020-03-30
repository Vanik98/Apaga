package com.example.apaga.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.apaga.R
import com.example.apaga.ui.address.AddressActivity
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.main.MainActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import javax.inject.Inject


class LoginFragment : BaseFragment(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: ImageView
    private lateinit var fbSignInLBtn: LoginButton
    private lateinit var fbSignInIV: ImageView
    private lateinit var callbackManager: CallbackManager
    private lateinit var scrollView: ScrollView
    private lateinit var signInVersions: TextView

    override fun findViewsById(view: View) {
        username = view.findViewById(R.id.login_et_username)
        password = view.findViewById(R.id.login_et_password)
        login = view.findViewById(R.id.login_btn_login)
        fbSignInIV = view.findViewById(R.id.login_iv_facebook_custom)
        scrollView = view.findViewById(R.id.login_sv)
        signInVersions = view.findViewById(R.id.login_tv_sign_in_versions)
        emailRegistration = view.findViewById(R.id.login_iv_email)
        fbSignInLBtn = view.findViewById(R.id.login_btn_facebook)
    }

    override fun setViewsOnClickListener() {
        login.setOnClickListener {
            presenter.loginWithEmail(username.text.toString(), password.text.toString())
        }

        emailRegistration.setOnClickListener {
            (activity as MainActivity).navigate(R.id.nav_registration)
        }

        fbSignInIV.setOnClickListener {
            fbSignInLBtn.performClick()
        }

        fbSignInLBtn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
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

        signInVersions.setOnClickListener {
            scrollView.fullScroll(View.FOCUS_DOWN)
        }
    }

    override fun setViewsOptions() {
        fbSignInLBtn.setReadPermissions(listOf("logo_email", "public_profile"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        callbackManager = CallbackManager.Factory.create()
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view
    }

    override fun openHomeActivity() {
        startActivity(Intent(activity, AddressActivity::class.java))
        activity!!.finish()
    }

    override fun openAddressActivity() {
        startActivity(Intent(activity, AddressActivity::class.java))
        activity!!.finish()
    }



}

