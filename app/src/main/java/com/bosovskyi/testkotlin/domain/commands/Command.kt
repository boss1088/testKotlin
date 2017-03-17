package com.bosovskyi.testkotlin.domain.commands

/**
 * Created by boss1088 on 3/17/17.
 */
interface Command<T> {
    fun execute(): T
}