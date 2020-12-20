package com.example.theair.core.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

// this is networkUtils class for functions that works with network connectivity
object NetworkUtil {


    // this fun is used to check for internet connectivity
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}