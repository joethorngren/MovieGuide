package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.modules.FavoritesModule
import com.esoxjem.movieguide.di.modules.MovieDetailsModule
import com.esoxjem.movieguide.di.scopes.DetailsScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = [
    MovieDetailsModule::class,
    FavoritesModule::class
])
interface MovieDetailsFragmentSubcomponent : AndroidInjector<MovieDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsFragment>()
}
