package com.esoxjem.movieguide

import com.google.gson.annotations.SerializedName

/**
 * Created by ivan on 8/20/2017.
 */

class MoviesWraper {

    @SerializedName("results")
    var movieList: List<Movie>? = null
}
