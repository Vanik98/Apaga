package com.example.apaga.ui.main

import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.login.LoginFragment
import com.example.apaga.ui.registration.RegistrationFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {


    @Inject
    lateinit var presenter: MainContract.Presenter
//    @Inject lateinit var  regFragment: RegistrationFragment
//    @Inject lateinit var loginFragment: LoginFragment
    private lateinit var fragTrans: FragmentTransaction
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

    //    private void registration(){
//        mRegistration = findViewById(R.id.tv_createAccount);
//        mRegistration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mFragTrans = getFragmentManager().beginTransaction();
//                mFragTrans.replace(R.id.mainId, mRegFragment);
//                mFragTrans.commit();
//            }
//        });
//    }
//    private void login(){
//        mBtnLogin = findViewById(R.id.btn_login);
//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
    fun showFragment(framgmetName: String) {
//        fragTrans = fragmentManager.beginTransaction()
//        when (framgmetName) {
//            "login" -> {
//                fragTrans.replace(R.id.container, loginFragment)
//                fragTrans.commit()
//            }
//            REGISTRATION_FRAGMENT -> {
//                fragTrans.replace(R.id.container, regFragment)
//                fragTrans.commit()
//            }
//            else -> {
//            }
//        }
    }

    private fun actionWithXmlViews() {
        findViewIds()
        setViewParameters()
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


