package com.esoxjem.movieguide.di.modules;

import com.esoxjem.movieguide.details.MovieDetailsPresenter;
import com.esoxjem.movieguide.details.MovieDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule {

    @Provides
    MovieDetailsPresenter providePresenter() {
        return new MovieDetailsPresenterImpl();
    }

}
