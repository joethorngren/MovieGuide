package com.esoxjem.movieguide.listing

/**
 * @author arun
 */
interface MoviesListingPresenter {

    fun displayMovies()

    fun setView(view: MoviesListingView)

    fun destroy()
}
