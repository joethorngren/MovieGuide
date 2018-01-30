package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.details.MovieDetailsPresenter
import com.esoxjem.movieguide.details.MovieDetailsPresenterImpl
import com.esoxjem.movieguide.di.scopes.DetailsScope
import com.esoxjem.movieguide.favorites.FavoritesInteractor
import dagger.Module
import dagger.Provides


/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
class MovieDetailsModule {

    @Provides
    @DetailsScope
    fun providePresenter(favoritesInteractor: FavoritesInteractor): MovieDetailsPresenter {
        return MovieDetailsPresenterImpl(favoritesInteractor)
    }

}
