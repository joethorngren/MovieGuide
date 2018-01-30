package com.esoxjem.movieguide.di.modules

import android.app.Activity
import android.support.v4.app.Fragment
import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.di.DetailsActivityComponent
import com.esoxjem.movieguide.di.ListingActivityComponent
import com.esoxjem.movieguide.di.ListingComponent
import com.esoxjem.movieguide.listing.MoviesListingActivity
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [
DetailsActivityComponent::class,
ListingActivityComponent::class,
ListingComponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MoviesListingActivity::class)
    abstract fun bindMoviesListingActivityInjectorFactory(builder: ListingActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MovieDetailsActivity::class)
    abstract fun bindMovieDetailsActivityInjectorFactory(builder: DetailsActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @FragmentKey(MoviesListingFragment::class)
    abstract fun bindMoviesListingFragmentInjectorFactory(builder: ListingComponent.Builder): AndroidInjector.Factory<out Fragment>
}