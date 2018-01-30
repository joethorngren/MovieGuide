package com.esoxjem.movieguide.details

import com.esoxjem.movieguide.Movie

/**
 * @author arun
 */
interface MovieDetailsPresenter {

    fun showDetails(movie: Movie)

    fun setView(view: MovieDetailsView)

    fun showFavoriteButton(movie: Movie?)

    fun onFavoriteClick(movie: Movie?)

    fun destroy()
}
