package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.details.MovieDetailsPresenter
import com.esoxjem.movieguide.details.MovieDetailsPresenterImpl
import com.esoxjem.movieguide.di.scopes.DetailsScope

import dagger.Module
import dagger.Provides

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
class DetailsModule {

    @Provides
    @DetailsScope
    fun providePresenter(): MovieDetailsPresenter {
        return MovieDetailsPresenterImpl()
    }

}
