package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.scopes.DetailsScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = arrayOf(DetailsModule::class))
interface DetailsComponent {
    fun inject(target: MovieDetailsFragment)

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Bui<MovieDetailsActivity>
}
