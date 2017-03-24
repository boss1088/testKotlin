package com.bosovskyi.testkotlin.data.server

import com.bosovskyi.testkotlin.data.db.ShowDb
import com.bosovskyi.testkotlin.domain.datasource.ShowsDataSource
import com.bosovskyi.testkotlin.domain.mappers.ServerDataMapper
import com.bosovskyi.testkotlin.domain.model.ShowsList

/**
 * Created by boss1088 on 3/24/17.
 */
class ShowsServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                  val showDb: ShowDb = ShowDb()) : ShowsDataSource {

    override fun requestPopularShows(): ShowsList? {
        val result = ShowsRequest().execute()
        val converted = dataMapper.convertFromDataModel(result)
        showDb.saveShows(converted)
        return showDb.requestPopularShows()
    }
}