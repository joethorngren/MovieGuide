package com.esoxjem.movieguide.listing

import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.util.RxUtils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author arun
 */
class MoviesListingPresenterImpl(private val moviesInteractor: MoviesListingInteractor) : MoviesListingPresenter {

    private var view: MoviesListingView? = null

    private var fetchSubscription: Disposable? = null

    private val isViewAttached: Boolean
        get() = view != null

    override fun setView(view: MoviesListingView) {
        this.view = view
        displayMovies()
    }

    override fun destroy() {
        view = null
        RxUtils.unsubscribe(fetchSubscription)
    }

    override fun displayMovies() {
        showLoading()
        fetchSubscription = moviesInteractor.fetchMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onMovieFetchSuccess,
                           this::onMovieFetchFailed)

    }

    private fun showLoading() {
        if (isViewAttached) {
            view?.loadingStarted()
        }
    }

    private fun onMovieFetchSuccess(movies: List<Movie>) {
        if (isViewAttached) {
            view?.showMovies(movies)
        }
    }

    private fun onMovieFetchFailed(e: Throwable) {
        view?.loadingFailed(e.message)
    }
}
