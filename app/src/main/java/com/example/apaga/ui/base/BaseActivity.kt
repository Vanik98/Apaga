
package com.example.apaga.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.apaga.MvpApp
import com.example.apaga.di.component.ActivityComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule


abstract class BaseActivity : AppCompatActivity(), MvpView, BaseFragment.Callback {
    private lateinit var mProgressDialog: ProgressDialog
    private lateinit var mActivityComponent: ActivityComponent
//    private var mUnBinder: Unbinder = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MvpApp).applicationComponent)
                .build()
    }

    val activityComponent: ActivityComponent
        get() = mActivityComponent

//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    fun requestPermissionsSafely(permissions: Array<String?>?, requestCode: Int) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(permissions, requestCode)
//        }
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    fun hasPermission(permission: String?): Boolean {
//        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
//                checkSelfPermission(permission) === PackageManager.PERMISSION_GRANTED
//    }

    override fun showLoading() {
//        hideLoading()
//        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
//        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
//            mProgressDialog!!.cancel()
//        }
    }

    private fun showSnackBar(message: String) {
//        val snackbar: Snackbar = Snackbar.make(findViewById(R.id.content),
//                message, Snackbar.LENGTH_SHORT)
//        val sbView: View = snackbar.getView()
//        val textView = sbView
//                .findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
//        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
//        snackbar.show()
    }

    override fun onError(message: String) {
//        if (message != null) {
//            showSnackBar(message)
//        } else {
//            showSnackBar(getString(R.string.some_error))
//        }
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String) {
//        if (message != null) {
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
//        }
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
//        return NetworkUtils.isNetworkConnected(applicationContext)
        return  true
    }

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}
    override fun hideKeyboard() {
//        val view: View = this.getCurrentFocus()
//        if (view != null) {
//            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(view.windowToken, 0)
//        }
    }

    override fun openActivityOnTokenExpire() {
//        startActivity(LoginActivity.getStartIntent(this))
//        finish()
    }

//    fun setUnBinder(unBinder: Unbinder) {
//        mUnBinder = unBinder
//    }

    override fun onDestroy() {
//        if (mUnBinder != null) {
//            mUnBinder.unbind()
//        }
        super.onDestroy()
    }

    abstract fun setUp()
}