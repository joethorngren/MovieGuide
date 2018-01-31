package com.esoxjem.movieguide.di.modules

import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.scopes.DetailsScope
import com.esoxjem.movieguide.di.scopes.ListingScope
import com.esoxjem.movieguide.listing.MoviesListingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ListingScope
    @ContributesAndroidInjector(modules = [MoviesListingModule::class])
    abstract fun bindMoviesListingFragment(): MoviesListingFragment

    @DetailsScope
    @ContributesAndroidInjector(modules = [
        MovieDetailsModule::class,
        FavoritesModule::class
    ])
    abstract fun bindMovieDetailsFragment(): MovieDetailsFragment
}