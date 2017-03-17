package com.bosovskyi.testkotlin.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by boss1088 on 3/17/17.
 */

class ShowsRequest {

    companion object {
        private val API_KEY = "93cf2a3da65fb6b878f0a7b3b1593a32"
        private val URL = "https://api.themoviedb.org/3/tv/popular"

        private val COMPLETE_URL = "$URL?api_key=$API_KEY"
    }

    fun execute(): ShowsRequestResult  {
        val showsJson = URL(COMPLETE_URL).readText()
        return Gson().fromJson(showsJson, ShowsRequestResult::class.java)
    }
}