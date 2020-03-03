package com.example.apaga.ui.home

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View {
    @Inject
    lateinit var presenter: HomeContract.Presenter
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var navController: NavController
    private lateinit var nameHeader: TextView
    private lateinit var emailHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        activityComponent.inject(this)
        presenter.onAttach(this)
        actionWithXmlViews()
    }

    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun actionWithXmlViews() {
        findViewIds()
        setNavigation()
        setButtonsClickListener()
    }

    private fun findViewIds() {
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
//        nameHeader = navView.findViewById(R.id.tv_nav_header_email)
//        emailHeader = navView.findViewById(R.id.tv_nav_header_email)
    }

    private fun setButtonsClickListener() {}

    private fun setNavigation() {
        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_payment, R.id.nav_buy_bags, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun showSnackbar() {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
