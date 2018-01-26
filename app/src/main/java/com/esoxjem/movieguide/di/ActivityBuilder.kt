package com.esoxjem.movieguide.di

import android.app.Activity
import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MoviesListingActivity::class)
    abstract fun bindListingActivity(builder: ListingComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MovieDetailsActivity::class)
    abstract fun bindDetailsActivity(builder: DetailsComponent.Builder): AndroidInjector.Factory<out Activity>

}