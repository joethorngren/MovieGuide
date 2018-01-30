package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.*
import javax.inject.Singleton


import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<BaseApplication> {

    fun plus(detailsModule: DetailsModule): MovieDetailsFragmentSubcomponent

    fun plus(listingModule: ListingModule): MoviesListingFragmentSubcomponent

}
