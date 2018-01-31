package com.esoxjem.movieguide.di

import android.support.v4.app.Fragment
import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    MoviesListingFragmentSubcomponent::class,
    MovieDetailsFragmentSubcomponent::class
])
abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(MoviesListingFragment::class)
    abstract fun bindMoviesListingFragmentInjectorFactory(builder: MoviesListingFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(MovieDetailsFragment::class)
    abstract fun bindMovieDetailsFragmentInjectorFactory(builder: MovieDetailsFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}