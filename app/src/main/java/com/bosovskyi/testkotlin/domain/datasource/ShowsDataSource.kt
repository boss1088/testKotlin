package com.bosovskyi.testkotlin.domain.datasource

import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/24/17.
 */
interface ShowsDataSource {

    fun requestPopularShows(): ShowsList?

}