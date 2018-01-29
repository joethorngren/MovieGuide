package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import javax.inject.Singleton


import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, NetworkModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun plus(listingModule: ListingModule): ListingComponent
}
