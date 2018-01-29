package com.esoxjem.movieguide.di.components

import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.*
import javax.inject.Singleton


import dagger.Component
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
interface AppComponent {

    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun plus(listingModule: ListingModule): ListingComponent

    fun inject(application: BaseApplication)
}
