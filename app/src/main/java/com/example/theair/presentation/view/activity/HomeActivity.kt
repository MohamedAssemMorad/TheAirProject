package com.example.theair.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.theair.R
import com.example.theair.core.helpers.TransitionType
import com.example.theair.core.utils.FragmentUtil
import com.example.theair.presentation.view.fragment.MovieListFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        if (savedInstanceState == null) {
            FragmentUtil.replaceFragment(
                this,
                MovieListFragment(), false, TransitionType.NONE, MovieListFragment.TAG
            )
        }

    }
}