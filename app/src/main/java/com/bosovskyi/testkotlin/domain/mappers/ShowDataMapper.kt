package com.bosovskyi.testkotlin.domain.mappers

import com.bosovskyi.testkotlin.data.ShowListEntity
import com.bosovskyi.testkotlin.data.ShowsRequestResult
import com.bosovskyi.testkotlin.domain.model.ShowListEntity as ShowModel
import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/17/17.
 */

class ShowDataMapper {

    fun convertFromDataModel(showsResult: ShowsRequestResult): ShowsList {
        return ShowsList(showsResult.page, showsResult.total_pages, convertShowListToDomain(showsResult.results))
    }

    fun convertShowListToDomain(list: List<ShowListEntity>): List<ShowModel> {
        return list.mapIndexed { _, entity ->
            convertShowEntityToDomain(entity.copy())
        }
    }

    fun convertShowEntityToDomain(entity: ShowListEntity): ShowModel {
        return ShowModel(entity.id, entity.name, generatePosterUrl(entity.poster_path), entity.vote_average.toString())
    }

    fun generatePosterUrl(posterPath: String) = "https://image.tmdb.org/t/p/w300$posterPath"
}
