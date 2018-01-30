package com.esoxjem.movieguide.details

import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.favorites.FavoritesInteractor



/**
 * @author arun
 */
class MovieDetailsPresenterImpl constructor(private var favoritesInteractor: FavoritesInteractor) : MovieDetailsPresenter {

    private var view: MovieDetailsView? = null

    private val isViewAttached: Boolean
        get() = view != null

    override fun setView(view: MovieDetailsView) {
        this.view = view
    }

    override fun showFavoriteButton(movie: Movie?) {
        val isFavorite = favoritesInteractor.isFavorite(movie?.id)
        if (isViewAttached) {
            if (isFavorite) {
                view?.showFavorited()
            } else {
                view?.showUnFavorited()
            }
        }
    }

    override fun onFavoriteClick(movie: Movie?) {
        if (isViewAttached) {
            val isFavorite = favoritesInteractor.isFavorite(movie?.id)
            if (isFavorite) {
                favoritesInteractor.unFavorite(movie?.id)
                view?.showUnFavorited()
            } else {
                favoritesInteractor.setFavorite(movie)
                view?.showFavorited()
            }
        }
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
