package com.bosovskyi.testkotlin.data

/**
 * Created by boss1088 on 3/17/17.
 */

data class ShowsRequestResult(val page: Int, val results: List<ShowListEntity>, val total_results: Int,
                              val total_pages: Int)

data class ShowListEntity(val poster_path: String, val popularity: Double, val id: Int,
                          val backdrop_path: String, val vote_average: Double, val overview: String,
                          val first_air_date: String, val origin_country: List<String> = ArrayList(),
                          val genre_ids: List<Int> = ArrayList(), val original_language: String,
                          val vote_count: Int, val name: String, val original_name: String)