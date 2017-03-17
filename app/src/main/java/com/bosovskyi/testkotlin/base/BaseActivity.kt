package com.bosovskyi.testkotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Created by boss1088 on 3/15/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setView()
        setupToolbar()
    }

    abstract fun setView()

    fun setupToolbar() {
        if (getToolbar() != null) {
            setSupportActionBar(getToolbar())
            getToolbar()?.setPadding(0, getStatusBarHeight(), 0, 0)
        }
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }

        return result
    }

    abstract fun getToolbar(): Toolbar?
}