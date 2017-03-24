package com.bosovskyi.testkotlin.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.bosovskyi.testkotlin.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by boss1088 on 3/24/17.
 */
class ShowsDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ShowsDbHelper.DB_NAME, null, ShowsDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "show.db"
        val DB_VERSION = 1
        val instance by lazy { ShowsDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(ShowTable.NAME, true,
                ShowTable.ID to INTEGER + PRIMARY_KEY,
                ShowTable.SHOW_NAME to TEXT,
                ShowTable.POSTER_URL to TEXT,
                ShowTable.AVERAGE_RATING to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(ShowTable.NAME, true)
        onCreate(db)
    }
}