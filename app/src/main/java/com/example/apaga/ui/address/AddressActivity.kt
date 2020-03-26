package com.example.apaga.ui.address

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.home.HomeActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject


class AddressActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    @Inject lateinit var presenter: AddressPresenter
    lateinit var confirm : Button
    private lateinit var locationManager : LocationManager
    private lateinit var locationListener: LocationListener
    private lateinit var myGelolocation:MarkerOptions
    @Inject lateinit var gc:Geocoder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        activityComponent.inject(this)
        setMap()
        confirm = findViewById(R.id.btn_confirm)
        confirm.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setMap(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun showGeolocation(){
//        myGelolocation = MarkerOptions().position(LatLng(40.1811, 44.5136)).title("Vanik")
//        mMap.addMarker(myGelolocation)
        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

        }
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                val latiude = location!!.latitude
                val longitude = location!!.longitude
                val list = gc.getFromLocation(40.1811, 44.5136, 1)
                val address: Address = list[0]
                Log.i("vvv", address.locality)
                println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+address.locality)
//                val icon= BitmapDescriptorFactory.fromResource(R.drawable.vanik)
                myGelolocation = MarkerOptions().position(LatLng(latiude, longitude))
//                        .title(user.name).icon(icon)
                mMap.addMarker(myGelolocation)
                mMap.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                        latiude,
                                        longitude
                                ), 15.0f
                        )
                )
            }

            override fun onStatusChanged(
                    provider: String?,
                    status: Int,
                    extras: Bundle?
            ) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {

            }
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100000, 20f, locationListener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100000, 20f, locationListener)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1)
        }
        showGeolocation()
    }

}
