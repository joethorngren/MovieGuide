package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.MoviesListingModule
import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = [MoviesListingModule::class])
interface MoviesListingFragmentSubcomponent : AndroidInjector<MoviesListingFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesListingFragment>()
}
