package com.bosovskyi.testkotlin.ui.utils

import android.os.Build

/**
 * Created by boss1088 on 3/23/17.
 */
inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}

inline fun lessLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}