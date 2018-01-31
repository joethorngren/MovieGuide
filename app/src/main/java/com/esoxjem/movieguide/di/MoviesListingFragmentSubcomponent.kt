package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.MoviesListingModule
import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingFragment

import dagger.Subcomponent

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = arrayOf(MoviesListingModule::class))
interface MoviesListingFragmentSubcomponent {

    fun inject(fragment: MoviesListingFragment): MoviesListingFragment

    @Subcomponent.Builder
    interface Builder {
        fun moviesListingModule(moviesListingModule: MoviesListingModule): Builder
        fun build(): MoviesListingFragmentSubcomponent
    }
}
