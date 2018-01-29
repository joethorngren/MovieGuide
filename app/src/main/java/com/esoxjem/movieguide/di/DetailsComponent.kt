package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.scopes.DetailsScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent : AndroidInjector<MovieDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsFragment>()
}
