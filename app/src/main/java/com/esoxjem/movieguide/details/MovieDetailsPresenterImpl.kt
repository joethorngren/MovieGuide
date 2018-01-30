package com.esoxjem.movieguide.details

import com.esoxjem.movieguide.Movie

/**
 * @author arun
 */
class MovieDetailsPresenterImpl : MovieDetailsPresenter {

    private var view: MovieDetailsView? = null

    private val isViewAttached: Boolean
        get() = view != null

    override fun setView(view: MovieDetailsView) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

    override fun showDetails(movie: Movie) {
        if (isViewAttached) {
            view?.showDetails(movie)
        }
    }
}
