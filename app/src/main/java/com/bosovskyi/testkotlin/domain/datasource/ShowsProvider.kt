package com.bosovskyi.testkotlin.domain.datasource

import com.bosovskyi.testkotlin.data.db.ShowDb
import com.bosovskyi.testkotlin.data.server.ShowsServer
import com.bosovskyi.testkotlin.domain.model.ShowsList
import com.bosovskyi.testkotlin.extensions.firstResult

/**
 * Created by boss1088 on 3/24/17.
 */
class ShowsProvider(val sources: List<ShowsDataSource> = SOURCES) {

    companion object {
        val SOURCES = listOf(ShowDb(), ShowsServer())
    }

    fun requestPopularShows(reload: Boolean): ShowsList = sources.firstResult {
        requestSource(it, reload)
    }

    private fun requestSource(source: ShowsDataSource, reload: Boolean): ShowsList? {
        if (reload && source is ShowDb) {
            return null
        }

        val res = source.requestPopularShows()
        return if (res != null && res.size > 0) res else null
    }
}