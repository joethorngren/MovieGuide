package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.di.scopes.DetailsScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@DetailsScope
@Subcomponent
interface DetailsActivityComponent : AndroidInjector<MovieDetailsActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsActivity>()
}