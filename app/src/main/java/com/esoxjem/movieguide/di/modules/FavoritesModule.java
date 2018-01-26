package com.esoxjem.movieguide.di.modules;

import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.favorites.FavoritesInteractorImpl;
import com.esoxjem.movieguide.favorites.FavoritesStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 */
@Module(includes = AppModule.class)
public class FavoritesModule {

    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store) {
        return new FavoritesInteractorImpl(store);
    }
}
