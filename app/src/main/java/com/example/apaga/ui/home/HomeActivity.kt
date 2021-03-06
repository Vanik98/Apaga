package com.example.apaga.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
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
import com.example.apaga.ui.address.AddressActivity
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.settings.SettingsActivity
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
    private lateinit var navIcon: ImageView
    private lateinit var nameHeader: TextView
    private lateinit var emailHeader: TextView
    private val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        activityComponent.inject(this)
        presenter.onAttach(this)
        setUp()
    }

    override fun navigate(navigateId: Int) {
        navController.navigate(navigateId)
    }

    override fun findViewsById() {
        print("")
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
//        navIcon = findViewById(R.id.iv_toolbar_nav_icon)
        navController = findNavController(R.id.nav_host_fragment)
//        nameHeader = navView.findViewById(R.id.tv_nav_header_email)
//        emailHeader = navView.findViewById(R.id.tv_nav_header_email)
    }

    override fun setViewsOptions() {
        setNavigation()
    }


    private fun setNavigation() {
        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_dashboard,
                R.id.nav_payment, R.id.nav_scheduled_pickup, R.id.nav_buy_bags,
                R.id.nav_qr_code_scanner, R.id.nav_notifications, R.id.nav_settings,
                R.id.nav_logout), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    private fun showSnackbar() {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(context, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
