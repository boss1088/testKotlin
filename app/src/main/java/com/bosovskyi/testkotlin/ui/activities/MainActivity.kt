package com.bosovskyi.testkotlin.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.bosovskyi.testkotlin.R
import com.bosovskyi.testkotlin.base.BaseActivity
import com.bosovskyi.testkotlin.domain.commands.PopularShowsCommand
import com.bosovskyi.testkotlin.ui.adapters.ShowsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemsList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = PopularShowsCommand().execute()
            uiThread { itemsList.adapter = ShowsAdapter(result.shows) }
        }
    }

    override fun setView() = setContentView(R.layout.activity_main)

    override fun getToolbar(): Toolbar? = toolbar
}
