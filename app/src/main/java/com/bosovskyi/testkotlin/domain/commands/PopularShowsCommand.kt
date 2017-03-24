package com.bosovskyi.testkotlin.domain.commands

import com.bosovskyi.testkotlin.domain.datasource.ShowsProvider
import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/17/17.
 */
class PopularShowsCommand(val reload: Boolean = false, val showsProvider: ShowsProvider = ShowsProvider()): Command<ShowsList> {

    override fun execute(): ShowsList {
        return showsProvider.requestPopularShows(reload)
    }

}