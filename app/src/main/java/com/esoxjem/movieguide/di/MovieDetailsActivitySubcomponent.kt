package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface MovieDetailsActivitySubcomponent : AndroidInjector<MovieDetailsActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsActivity>()
}