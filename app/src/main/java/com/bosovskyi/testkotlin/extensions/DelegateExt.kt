package com.bosovskyi.testkotlin.extensions

import kotlin.reflect.KProperty

/**
 * Created by boss1088 on 3/23/17.
 */
object DelegateExt {
    fun <T> notNullSingleValue() = NotNullSingleValue<T>()
}

class NotNullSingleValue<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}