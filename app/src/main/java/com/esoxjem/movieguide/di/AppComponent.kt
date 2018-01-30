package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.*
import javax.inject.Singleton


import dagger.Component

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, FavoritesModule::class])
interface AppComponent {

    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun plus(listingModule: ListingModule): ListingComponent
}
