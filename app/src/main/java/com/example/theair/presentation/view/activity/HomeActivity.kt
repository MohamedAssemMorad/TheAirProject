package com.example.theair.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.theair.R
import com.example.theair.core.helpers.TransitionType
import com.example.theair.core.utils.FragmentUtil
import com.example.theair.presentation.view.fragment.MovieListFragment
import com.example.theair.presentation.view.fragment.MovieRecommendationsFragment
import kotlinx.android.synthetic.main.activity_home.*

// here in this class we init bottom navigation bar and move to main fragment
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        FragmentUtil.replaceFragment(
            this,
            MovieListFragment(),
            true,
            TAG = MovieListFragment.TAG
        )

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> FragmentUtil.replaceFragment(
                    this,
                    MovieRecommendationsFragment(),
                    true,
                    TAG = MovieRecommendationsFragment.TAG
                )
                R.id.person -> FragmentUtil.replaceFragment(
                    this,
                    MovieListFragment(),
                    true,
                    TAG = MovieListFragment.TAG
                )
//                R.id.settings->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

}
