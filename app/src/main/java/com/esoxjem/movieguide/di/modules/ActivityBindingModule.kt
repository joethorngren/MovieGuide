package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMovieListingActivityInjectorFactory(): MoviesListingActivity

}