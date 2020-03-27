package com.example.apaga.ui.login

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController

import com.example.apaga.R
import com.example.apaga.ui.address.AddressActivity
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.ui.main.MainActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import javax.inject.Inject


class LoginFragment : BaseFragment(),LoginContract.View {

    @Inject
    lateinit var presenter:LoginContract.Presenter
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var emailRegistration: Button
    private lateinit var facebookSignIn: LoginButton
    private lateinit var signIn: ImageView
    private lateinit var callbackManager: CallbackManager
    private lateinit var navController: NavController
    private lateinit var scrollView: ScrollView
    private lateinit var signInVersions:TextView

    override fun findViewsById(view: View) {
        username = view.findViewById(R.id.et_username)
        password = view.findViewById(R.id.et_password)
        login = view.findViewById(R.id.btn_login)
        signIn = view.findViewById(R.id.iv_fb_sign_in)
        scrollView = view.findViewById(R.id.sv_login)
        signInVersions = view.findViewById(R.id.tv_sign_in_versions)
//        emailRegistration = view.findViewById(R.id.btn_email)
        facebookSignIn = view.findViewById(R.id.btn_facebook)
        navController = findNavController((activity as MainActivity), R.id.main_navigation_fragment)
    }

    override fun setViewsOnClickListener() {
        login.setOnClickListener {
            presenter.loginWithEmail(username.text.toString(), password.text.toString())
        }
//        emailRegistration.setOnClickListener {
//            navController.navigate(R.id.registrationFragment)
//        }
        signIn.setOnClickListener{
            facebookSignIn.performClick()
        }
        facebookSignIn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
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
        signInVersions.setOnClickListener{
            scrollView.fullScroll(View.FOCUS_DOWN)
        }
    }

    override fun setViewsOptions() {
        facebookSignIn.setReadPermissions(listOf("logo_email", "public_profile"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        callbackManager = CallbackManager.Factory.create()
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view
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
//        startActivity(Intent(activity, HomeActivity::class.java))
        startActivity(Intent(activity, AddressActivity::class.java))
        activity!!.finish()
    }

    fun getCallbackManager() = callbackManager
}

