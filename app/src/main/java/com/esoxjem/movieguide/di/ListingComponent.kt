package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingActivity
import com.esoxjem.movieguide.listing.MoviesListingFragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = [ListingModule::class])
interface ListingComponent : AndroidInjector<MoviesListingActivity> {

    fun inject(fragment: MoviesListingFragment): MoviesListingFragment

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesListingActivity>()

}
