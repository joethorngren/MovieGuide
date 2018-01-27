package com.esoxjem.movieguide.di.modules;

import com.esoxjem.movieguide.listing.MoviesListingInteractor;
import com.esoxjem.movieguide.listing.MoviesListingInteractorImpl;
import com.esoxjem.movieguide.listing.MoviesListingPresenter;
import com.esoxjem.movieguide.listing.MoviesListingPresenterImpl;
import com.esoxjem.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule {

    @Provides
    MoviesListingInteractor provideMovieListingInteractor(TmdbWebService tmdbWebService) {

        return new MoviesListingInteractorImpl(tmdbWebService);

    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {

        return new MoviesListingPresenterImpl(interactor);

    }
}
