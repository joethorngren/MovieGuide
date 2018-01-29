package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import android.app.Activity
import com.esoxjem.movieguide.di.components.MoviesListingActivitySubcomponent
import dagger.android.AndroidInjector



@Module(subcomponents = [MoviesListingActivitySubcomponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MoviesListingActivity::class)
    abstract fun bindMovieListingActivityInjectorFactory(builder: MoviesListingActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>

}