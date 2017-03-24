package com.bosovskyi.testkotlin.data.db

import com.bosovskyi.testkotlin.domain.model.ShowListEntity
import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/24/17.
 */
class DbDataMapper {

    fun convertToDomain(list: List<Show>) = with(list) {
        val shows = list.map { convertShowToDomain(it) }
        ShowsList(1, 0, shows)
    }

    private fun convertShowToDomain(show: Show) = with(show) {
        ShowListEntity(_id, showName, posterUrl, averageRating)
    }

    fun convertFromDomain(showsList: ShowsList) = with(showsList) {
        showsList.shows.map { convertShowFromDomain(it) }
    }

    private fun convertShowFromDomain(show: ShowListEntity) = with(show) {
        Show(id, name, posterUrl, averageRating)
    }
}