package com.esoxjem.movieguide.di.modules;

import com.esoxjem.movieguide.details.MovieDetailsInteractor;
import com.esoxjem.movieguide.details.MovieDetailsInteractorImpl;
import com.esoxjem.movieguide.details.MovieDetailsPresenter;
import com.esoxjem.movieguide.details.MovieDetailsPresenterImpl;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule {
    @Provides
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
