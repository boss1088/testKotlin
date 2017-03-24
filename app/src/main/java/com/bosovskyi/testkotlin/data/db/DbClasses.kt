package com.bosovskyi.testkotlin.data.db

/**
 * Created by boss1088 on 3/24/17.
 */
class Show(val map: MutableMap<String, Any?>) {

    var _id: Long by map
    var showName: String by map
    var posterUrl: String by map
    var averageRating: String by map

    constructor(id:Long, showName: String, posterUrl: String, averageRating: String):
            this(HashMap()) {
        this._id = id
        this.showName = showName
        this.posterUrl = posterUrl
        this.averageRating = averageRating
    }
}