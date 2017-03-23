package com.bosovskyi.testkotlin.ui

import android.app.Application
import com.bosovskyi.testkotlin.ui.utils.DelegateExt

/**
 * Created by boss1088 on 3/23/17.
 */
class App : Application() {

    companion object {
        var instance: App by DelegateExt.notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}