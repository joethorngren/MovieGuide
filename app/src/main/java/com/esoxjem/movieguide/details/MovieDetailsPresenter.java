package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.Movie;

/**
 * @author arun
 */
public interface MovieDetailsPresenter {

    void showDetails(Movie movie);

    void setView(MovieDetailsView view);

    void destroy();
}
