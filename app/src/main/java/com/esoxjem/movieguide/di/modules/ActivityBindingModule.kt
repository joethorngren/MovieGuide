package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.listing.MoviesListingActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import android.app.Activity
import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.di.MovieDetailsActivitySubcomponent
import com.esoxjem.movieguide.di.MovieDetailsFragmentSubcomponent
import com.esoxjem.movieguide.di.MoviesListingActivitySubcomponent
import com.esoxjem.movieguide.di.MoviesListingFragmentSubcomponent
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector


@Module(subcomponents = [
    MoviesListingActivitySubcomponent::class
//    MovieDetailsActivitySubcomponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MoviesListingActivity::class)
    abstract fun bindMoviesListingActivityInjectorFactory(builder: MoviesListingActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>

//    @Binds
//    @IntoMap
//    @ActivityKey(MovieDetailsActivity::class)
//    abstract fun bindMovieDetailsActivityInjectorFactory(builder: MovieDetailsActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector(modules = [MovieDetailsActivityModule::class])
    abstract fun bindMovieDetailsActivityInjector(): MovieDetailsActivity

}