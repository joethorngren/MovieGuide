package com.esoxjem.movieguide.listing

import com.esoxjem.movieguide.Movie

/**
 * @author arun
 */
interface MoviesListingView {

    fun showMovies(movies: List<Movie>)

    fun loadingStarted()

    fun loadingFailed(errorMessage: String?)

    fun onMovieClicked(movie: Movie)
}
