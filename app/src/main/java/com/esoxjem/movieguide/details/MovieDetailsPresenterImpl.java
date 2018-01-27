package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.Movie;

/**
 * @author arun
 */
public class MovieDetailsPresenterImpl implements MovieDetailsPresenter {
    private MovieDetailsView view;

    public MovieDetailsPresenterImpl() {
    }

    @Override
    public void setView(MovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }

    @Override
    public void showDetails(Movie movie) {
        if (isViewAttached()) {
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }
}
