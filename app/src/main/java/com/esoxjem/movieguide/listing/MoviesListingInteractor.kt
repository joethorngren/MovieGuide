package com.esoxjem.movieguide.listing

import com.esoxjem.movieguide.Movie

import io.reactivex.Observable

/**
 * @author arun
 */
interface MoviesListingInteractor {

    fun fetchMovies(): Observable<List<Movie>>
}
