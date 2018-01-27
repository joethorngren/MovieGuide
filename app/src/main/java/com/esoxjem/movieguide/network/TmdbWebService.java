package com.esoxjem.movieguide.network;

import com.esoxjem.movieguide.MoviesWraper;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ivan on 8/20/2017.
 */

public interface TmdbWebService {

    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesWraper> highestRatedMovies();

}
