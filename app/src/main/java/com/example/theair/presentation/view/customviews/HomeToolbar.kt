package com.example.theair.presentation.view.customviews

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.theair.R

// custom view for toolbar
class HomeToolbar : Toolbar {

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            navigationIcon = context?.getDrawable(R.drawable.ic_back_button)
        }
    }

    fun showToolbar() {
        if (visibility == View.GONE || visibility == View.INVISIBLE) visibility = View.VISIBLE
    }

    fun hideToolbar() {
        if (visibility == View.VISIBLE) visibility = View.GONE
    }

    fun showBackIcon(activity: AppCompatActivity) {
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideBackIcon(activity: AppCompatActivity) {
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun showMenu() {
        menu.setGroupVisible(0, true)
    }

    fun hideMenu() {
        menu.setGroupVisible(0, false)
    }

    fun setBackgroundColorHide() {
        this.setBackgroundColor(ContextCompat.getColor(context!!, R.color.white_transparent))
    }
}