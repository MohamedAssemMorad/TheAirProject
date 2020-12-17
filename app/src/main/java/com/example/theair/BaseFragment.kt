package com.example.theair

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.example.theair.core.utils.NetworkUtil

open class BaseFragment : Fragment() {

    lateinit var contentContainer: FrameLayout
    lateinit var llNoInternet: LinearLayoutCompat
    lateinit var tvTryAgain: AppCompatTextView

    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = inflater.inflate(R.layout.fragment_base, container, false)


        setHasOptionsMenu(true)

        // no internet connection layout
        llNoInternet = parentView.findViewById(R.id.llNoInternet)

        // content layout to show child fragment's layout
        contentContainer = parentView.findViewById(R.id.layout_container)

        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mContext = view.context

        tvTryAgain = view.findViewById(R.id.tvTryAgain)
        tvTryAgain.setOnClickListener {
            internetCheckProcess()
        }
    }

    override fun onResume() {
        super.onResume()

        registerBroadcasts()
        internetCheckProcess()
    }

    override fun onPause() {
        try {
            unregisterBroadcasts()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace();
        }
        super.onPause()
    }

    open fun internetCheckProcess() {
        if (NetworkUtil.isNetworkAvailable(mContext)) {
            llNoInternet.visibility = View.GONE
            contentContainer.visibility = View.VISIBLE
        } else {
            contentContainer.visibility = View.GONE
            llNoInternet.visibility = View.VISIBLE
        }
    }

    private fun registerBroadcasts() {
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        mContext.registerReceiver(broadcastReceiver, intentFilter)
    }

    fun unregisterBroadcasts() {
        mContext.unregisterReceiver(broadcastReceiver)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            when (intent?.action) {
                ConnectivityManager.CONNECTIVITY_ACTION -> internetCheckProcess()
            }
        }
    }
}