package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import javax.inject.Singleton


import dagger.Component

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun plus(listingModule: ListingModule): ListingComponent
}
