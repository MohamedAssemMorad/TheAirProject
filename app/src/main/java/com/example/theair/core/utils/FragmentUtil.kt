package com.example.theair.core.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.theair.R
import com.example.theair.core.helpers.TransitionType

object FragmentUtil {

    // here addFragment() fun for adding activity
    fun addFragment(
        activity: AppCompatActivity,
        fragment: Fragment,
        addToBackstack: Boolean,
        transitionType: String = TransitionType.SLIDE_LEFT_RIGHT,
        TAG: String
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()

        if (transitionType == TransitionType.SLIDE_LEFT_RIGHT)
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )

        if (transitionType == TransitionType.SLIDE_UP_DOWN)
            transaction.setCustomAnimations(
                R.anim.slide_up,
                0,
                0,
                R.anim.slide_down
            )

        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(R.id.container_fragment, fragment, TAG)
            if (addToBackstack) {
                transaction.addToBackStack(TAG)
            }
        }

        transaction.commit()
    }

    // here this fun for replacing activity
    fun replaceFragment(
        activity: AppCompatActivity,
        fragment: Fragment,
        addToBackstack: Boolean,
        transitionType: String = TransitionType.SLIDE_LEFT_RIGHT,
        TAG: String
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()

        if (transitionType == TransitionType.SLIDE_LEFT_RIGHT)
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )

        if (transitionType == TransitionType.SLIDE_UP_DOWN)
            transaction.setCustomAnimations(
                R.anim.slide_up,
                0,
                0,
                R.anim.slide_down
            )

        transaction.replace(R.id.container_fragment, fragment, TAG)

        if (addToBackstack) {
            transaction.addToBackStack(TAG)
        }

        transaction.commit()
    }
}