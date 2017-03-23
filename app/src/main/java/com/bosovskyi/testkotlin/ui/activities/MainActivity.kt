package com.bosovskyi.testkotlin.ui.activities

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import com.bosovskyi.testkotlin.R
import com.bosovskyi.testkotlin.base.BaseActivity
import com.bosovskyi.testkotlin.domain.commands.PopularShowsCommand
import com.bosovskyi.testkotlin.domain.model.ShowListEntity
import com.bosovskyi.testkotlin.ui.adapters.ShowsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val columnCount =
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2
        itemsList.layoutManager = GridLayoutManager(this, columnCount)

        getShowsAndUpdateAdapter()
    }

    fun getShowsAndUpdateAdapter() {
        doAsync {
            val result = PopularShowsCommand().execute()
            uiThread {
                itemsList.adapter = ShowsAdapter(result.shows,
                        object : ShowsAdapter.OnItemClickListener{
                            override fun invoke(showEntity: ShowListEntity) {
                                toast(showEntity.name)
                            }
                        })
                itemsList.scheduleLayoutAnimation()
            }
        }

    }

    override fun setView() = setContentView(R.layout.activity_main)

    override fun getToolbar(): Toolbar? = toolbar
}
