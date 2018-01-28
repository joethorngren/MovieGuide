package com.esoxjem.movieguide.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources {
        return context.resources
    }
}
