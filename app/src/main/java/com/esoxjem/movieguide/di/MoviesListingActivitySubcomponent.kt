package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface MoviesListingActivitySubcomponent : AndroidInjector<MoviesListingActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesListingActivity>()
}