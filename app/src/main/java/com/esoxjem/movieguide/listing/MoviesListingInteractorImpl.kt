package com.esoxjem.movieguide.listing

import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.MoviesWraper
import com.esoxjem.movieguide.network.TmdbWebService

import io.reactivex.Observable

/**
 * @author arun
 */
class MoviesListingInteractorImpl(private val tmdbWebService: TmdbWebService) : MoviesListingInteractor {

    override fun fetchMovies(): Observable<List<Movie>> {
        return tmdbWebService.highestRatedMovies().map { it.movieList }
    }
}
