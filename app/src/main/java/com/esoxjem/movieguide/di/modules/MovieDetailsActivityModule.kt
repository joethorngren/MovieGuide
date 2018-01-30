package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.listing.Toaster
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsActivityModule {

    @Provides
    fun provideToaster(activity: MovieDetailsActivity): Toaster {
        return Toaster(activity)
    }

}