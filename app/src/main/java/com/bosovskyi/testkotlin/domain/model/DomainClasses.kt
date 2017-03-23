package com.bosovskyi.testkotlin.domain.model

/**
 * Created by boss1088 on 3/17/17.
 */

data class ShowsList(val page: Int, val totalPages: Int, val shows: List<ShowListEntity>) {

    val size: Int
        get() = shows.size

    operator fun get(position: Int) = shows[position]
}

data class ShowListEntity(val id: Int, val name: String, val posterUrl: String, val averageRating: String)
