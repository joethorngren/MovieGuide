package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.listing.MoviesListingInteractor
import com.esoxjem.movieguide.listing.MoviesListingInteractorImpl
import com.esoxjem.movieguide.listing.MoviesListingPresenter
import com.esoxjem.movieguide.listing.MoviesListingPresenterImpl
import com.esoxjem.movieguide.network.TmdbWebService

import dagger.Module
import dagger.Provides

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
class ListingModule {

    @Provides
    fun provideMovieListingInteractor(tmdbWebService: TmdbWebService): MoviesListingInteractor {
        return MoviesListingInteractorImpl(tmdbWebService)
    }

    @Provides
    fun provideMovieListingPresenter(interactor: MoviesListingInteractor): MoviesListingPresenter {
        return MoviesListingPresenterImpl(interactor)
    }
}
