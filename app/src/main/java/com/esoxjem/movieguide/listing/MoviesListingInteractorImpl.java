package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public class MoviesListingInteractorImpl implements MoviesListingInteractor {

    private TmdbWebService tmdbWebService;

    public MoviesListingInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {
        return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
    }
}
