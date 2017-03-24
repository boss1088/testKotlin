package com.bosovskyi.testkotlin.data.db

import com.bosovskyi.testkotlin.domain.datasource.ShowsDataSource
import com.bosovskyi.testkotlin.domain.model.ShowsList
import com.bosovskyi.testkotlin.extensions.clear
import com.bosovskyi.testkotlin.extensions.parseList
import com.bosovskyi.testkotlin.extensions.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by boss1088 on 3/24/17.
 */
class ShowDb(val showsDbHelper: ShowsDbHelper = ShowsDbHelper.instance,
             val dbDataMapper: DbDataMapper = DbDataMapper())
    :ShowsDataSource{

    override fun requestPopularShows() = showsDbHelper.use {
        val shows = select(ShowTable.NAME).parseList{Show(HashMap(it))}
        dbDataMapper.convertToDomain(shows)
    }

    fun saveShows(showsList: ShowsList) = showsDbHelper.use {
        clear(ShowTable.NAME)

        with(dbDataMapper.convertFromDomain(showsList)) {
            forEach {
                insert(ShowTable.NAME, *it.map.toVarargArray()) }
        }
    }
}