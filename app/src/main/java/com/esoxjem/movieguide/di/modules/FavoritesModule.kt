package com.esoxjem.movieguide.di.modules


import com.esoxjem.movieguide.di.scopes.DetailsScope
import com.esoxjem.movieguide.favorites.FavoritesInteractor
import com.esoxjem.movieguide.favorites.FavoritesInteractorImpl
import com.esoxjem.movieguide.favorites.FavoritesStore

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * @author pulkitkumar
 */
@Module
class FavoritesModule {

    @Provides
    @DetailsScope
    fun provideFavoritesInteractor(store: FavoritesStore): FavoritesInteractor {
        return FavoritesInteractorImpl(store)
    }
}