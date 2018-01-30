package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Subcomponent

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = [ListingModule::class])
interface MoviesListingFragmentSubcomponent {

    fun inject(fragment: MoviesListingFragment): MoviesListingFragment

}
