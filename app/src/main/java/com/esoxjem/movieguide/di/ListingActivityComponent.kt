package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ListingScope
@Subcomponent
interface ListingActivityComponent : AndroidInjector<MoviesListingActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesListingActivity>()
}