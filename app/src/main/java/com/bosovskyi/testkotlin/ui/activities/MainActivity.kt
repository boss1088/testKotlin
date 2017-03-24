package com.bosovskyi.testkotlin.ui.activities

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.bosovskyi.testkotlin.R
import com.bosovskyi.testkotlin.base.BaseActivity
import com.bosovskyi.testkotlin.domain.commands.PopularShowsCommand
import com.bosovskyi.testkotlin.ui.adapters.ShowsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val columnCount =
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2
        itemsList.layoutManager = GridLayoutManager(this, columnCount)

        getShowsAndUpdateAdapter(savedInstanceState == null)
    }

    fun getShowsAndUpdateAdapter(reload: Boolean) {
        showLoading()
        doAsync {
            val result = PopularShowsCommand(reload).execute()
            uiThread {
                val adapter = ShowsAdapter(result.shows) { toast(it.name) }
                hideLoading()
                itemsList.adapter = adapter
                itemsList.scheduleLayoutAnimation()
            }
        }

    }

    fun showLoading() {
        itemsList.visibility = View.GONE
        loadingContainer.visibility = View.VISIBLE
    }

    fun hideLoading() {
        loadingContainer.visibility = View.GONE
        itemsList.visibility = View.VISIBLE
    }

    override fun setView() = setContentView(R.layout.activity_main)

    override fun getToolbar(): Toolbar? = toolbar
}
