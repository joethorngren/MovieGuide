package com.esoxjem.movieguide.di


import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.ActivityBindingModule
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<BaseApplication> {

    fun moviesListingFragmentSubcomponentBuilder(): MoviesListingFragmentSubcomponent.Builder

    fun movieDetailsFragmentSubcomponentBuilder(): MovieDetailsFragmentSubcomponent.Builder
}
