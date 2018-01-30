package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.details.MovieDetailsFragment
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.scopes.DetailsScope
import dagger.Subcomponent

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    fun inject(target: MovieDetailsFragment)
}
