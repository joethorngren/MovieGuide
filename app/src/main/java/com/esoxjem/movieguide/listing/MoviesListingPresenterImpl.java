package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.util.RxUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author arun
 */
public class MoviesListingPresenterImpl implements MoviesListingPresenter {

    private MoviesListingView view;
    private MoviesListingInteractor moviesInteractor;
    private Disposable fetchSubscription;

    public MoviesListingPresenterImpl(MoviesListingInteractor interactor) {
        moviesInteractor = interactor;
    }

    @Override
    public void setView(MoviesListingView view) {
        this.view = view;
        displayMovies();
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(fetchSubscription);
    }

    @Override
    public void displayMovies() {
        showLoading();
        fetchSubscription = moviesInteractor.fetchMovies().subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(this::onMovieFetchSuccess,
                                                       this::onMovieFetchFailed);
    }

    private void showLoading() {
        if (isViewAttached()) {
            view.loadingStarted();
        }
    }

    private void onMovieFetchSuccess(List<Movie> movies) {
        if (isViewAttached()) {
            view.showMovies(movies);
        }
    }

    private void onMovieFetchFailed(Throwable e) {
        view.loadingFailed(e.getMessage());
    }

    private boolean isViewAttached() {
        return view != null;
    }
}
