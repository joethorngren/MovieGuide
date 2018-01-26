package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.modules.DetailsModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@Subcomponent(modules = arrayOf(DetailsModule::class))
interface DetailsComponent : AndroidInjector<MovieDetailsActivity>{

    fun inject(target: MovieDetailsFragment)

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsActivity>()
}
