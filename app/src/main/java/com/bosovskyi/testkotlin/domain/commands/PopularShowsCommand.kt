package com.bosovskyi.testkotlin.domain.commands

import com.bosovskyi.testkotlin.data.ShowsRequest
import com.bosovskyi.testkotlin.domain.mappers.ShowDataMapper
import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/17/17.
 */
class PopularShowsCommand: Command<ShowsList> {

    override fun execute(): ShowsList {
        val showsResult = ShowsRequest().execute()
        return ShowDataMapper().convertFromDataModel(showsResult)
    }

}