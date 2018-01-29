package com.esoxjem.movieguide.di.modules

import android.support.v4.app.Fragment
import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.DetailsComponent
import com.esoxjem.movieguide.di.ListingComponent
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(MovieDetailsFragment::class)
    abstract fun bindMovieDetailFragment(builder: DetailsComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(MoviesListingFragment::class)
    abstract fun bindMoviesListingFragment(builder: ListingComponent.Builder): AndroidInjector.Factory<out Fragment>
}