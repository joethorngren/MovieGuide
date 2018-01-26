package com.esoxjem.movieguide.di.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.esoxjem.movieguide.di.DetailsComponent
import com.esoxjem.movieguide.di.ListingComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Module(subcomponents = [ListingComponent::class, DetailsComponent::class])
class AppModule(application: Application) {
    private val context: Context

    init {
        context = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources {
        return context.resources
    }
}
