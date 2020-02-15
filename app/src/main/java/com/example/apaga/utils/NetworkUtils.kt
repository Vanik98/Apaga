package com.example.apaga.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtils {

    private fun NetworkUtils() { // This utility class is not publicly instantiable
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}