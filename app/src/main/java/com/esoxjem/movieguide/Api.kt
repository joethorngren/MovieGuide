package com.esoxjem.movieguide

/**
 * @author arun
 */
object Api {

    val BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342"
    val BASR_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780"

    fun getPosterPath(posterPath: String?): String {
        return BASE_POSTER_PATH + posterPath
    }

    fun getBackdropPath(backdropPath: String?): String {
        return BASR_BACKDROP_PATH + backdropPath
    }
}
